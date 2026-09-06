package com.example.HospitalManagementSystem.repositories;


import com.example.HospitalManagementSystem.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Long> {

    @Query("SELECT d FROM Doctor d WHERE d.isActive=true")
    List<Doctor> getAllDoctors();


    @Query("SELECT d FROM Doctor d WHERE d.isActive=true AND d.id=:id")
    Doctor getById(@Param("id") Long id);



}
