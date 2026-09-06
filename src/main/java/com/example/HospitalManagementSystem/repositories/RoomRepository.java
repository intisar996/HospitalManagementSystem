package com.example.HospitalManagementSystem.repositories;


import com.example.HospitalManagementSystem.entities.Prescription;
import com.example.HospitalManagementSystem.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room,Long> {

    @Query("SELECT p FROM Room p WHERE p.isActive=true")
    List<Room> getAllRooms();


    @Query("SELECT p FROM Room p WHERE p.isActive=true AND p.id=:id")
    Room getById(@Param("id") Long id);

}
