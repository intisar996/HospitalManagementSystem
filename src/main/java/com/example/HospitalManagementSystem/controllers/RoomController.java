package com.example.HospitalManagementSystem.controllers;


import com.example.HospitalManagementSystem.entities.Room;
import com.example.HospitalManagementSystem.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("room")
public class RoomController {

 RoomService roomService;


    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }






    @PostMapping("add")
    public Long addRoom(
            @RequestParam Integer roomNumber,
            @RequestParam Integer floor,
            @RequestParam String type,
            @RequestParam Integer capacity,
            @RequestParam Long hospitalId) {

        return roomService.addRoom(
                roomNumber,
                floor,
                type,
                capacity,
                hospitalId
        );
    }


    @GetMapping("getAll")
    public List<Room> getAllRoom(){
        return roomService.getAllRooms();
    }



    @GetMapping("getById")
    public Room getById(@RequestParam Long id) {
        return roomService.getById(id);
    }

    @PutMapping("update")
    public Room updateRoom(@RequestParam Long id,@RequestParam  String type, @RequestParam Integer capacity) throws Exception {
        return roomService.updateRoom(id,type,capacity);
    }


    @PutMapping("deleteById")
    public Boolean deleteRoom(@RequestParam Long id) throws Exception {
        return roomService.deleteRoom(id);

    }

}
