package com.example.HospitalManagementSystem.repositories;


import com.example.HospitalManagementSystem.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    @Query("SELECT a FROM Appointment a WHERE a.isActive=true")
    List<Appointment> getAllAppointment();


    @Query("SELECT a FROM Appointment a WHERE a.isActive=true AND a.id=:id")
    Appointment getById(@Param("id") Long id);


}
