package com.example.HospitalManagementSystem.services;


import com.example.HospitalManagementSystem.entities.Departments;
import com.example.HospitalManagementSystem.entities.Hospital;
import com.example.HospitalManagementSystem.entities.Room;
import com.example.HospitalManagementSystem.repositories.HospitalRepository;
import com.example.HospitalManagementSystem.repositories.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RoomService {


      RoomRepository roomRepository;
      HospitalRepository hospitalRepository;
      hospitalService hospitalService;


    public Long addRoom(Integer roomNumber, Integer floor,String type,Integer capacity,  Long  hospitalId){

        Hospital hospital = hospitalService.getById(hospitalId);
        if(hospital == null || hospital.getIsActive() == false){
            return -1L;
        }
        Room room = new Room();
        room.setIsActive(true);
        room.setCreatedDate(new Date());
        room.setRoomNumber(roomNumber);
        room.setFloor(floor);
        room.setType(type);
        room.setCapacity(capacity);

        Room saveRoom = roomRepository.save(room);

        List<Room> roomList = hospital.getRooms();
        roomList.add(saveRoom);
        hospital.setRooms(roomList);
        hospitalRepository.save(hospital);
        return room.getId();


    }


    public List<Room> getAllRooms(){
        return  roomRepository.getAllRooms();
    }


    public Room getById(Long id) {
        Optional<Room> room = roomRepository.findById(id);
        if (room.isPresent() && room.get().getIsActive()) {
            return room.get();
        }
        return new Room();
    }


    public Room updateRoom(Long id, String type, Integer capacity) throws Exception {
        Room roomToUpdate = roomRepository.getById(id);
        if (roomToUpdate == null) {
            throw new Exception("Hi Guys, Room is not found by the id");

        }
        roomToUpdate.setUpdateDate(new Date());
        roomToUpdate.setType(type);
        roomToUpdate.setCapacity(capacity);
        roomToUpdate = roomRepository.save(roomToUpdate);
        return roomToUpdate;
    }


    public Boolean  deleteRoom(Long id) throws Exception {
        Room roomToUpdate = roomRepository.getById(id);
        if (roomToUpdate == null) {
            throw new Exception("Hi Guys, Room is not found by the id");

        }
        roomToUpdate.setUpdateDate(new Date());
        roomToUpdate.setIsActive(false);
        roomToUpdate = roomRepository.save(roomToUpdate);
        return true;
    }


}
