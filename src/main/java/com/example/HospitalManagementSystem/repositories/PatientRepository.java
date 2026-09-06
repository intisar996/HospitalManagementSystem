package com.example.HospitalManagementSystem.repositories;


import com.example.HospitalManagementSystem.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {





    @Query("SELECT p FROM Patient p WHERE p.isActive=true")
    List<Patient> getAllPatients();


    @Query("SELECT p FROM Patient p WHERE p.isActive=true AND p.id=:id")
    Patient getById(@Param("id") Long id);



}
