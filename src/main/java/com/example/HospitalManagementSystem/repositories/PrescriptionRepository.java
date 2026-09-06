package com.example.HospitalManagementSystem.repositories;


import com.example.HospitalManagementSystem.entities.Patient;
import com.example.HospitalManagementSystem.entities.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription,Long> {


    @Query("SELECT p FROM Prescription p WHERE p.isActive=true")
    List<Prescription> getAllPrescriptions();


    @Query("SELECT p FROM Prescription p WHERE p.isActive=true AND p.id=:id")
    Prescription getById(@Param("id") Long id);


}
