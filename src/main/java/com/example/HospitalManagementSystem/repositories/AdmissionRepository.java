package com.example.HospitalManagementSystem.repositories;


import com.example.HospitalManagementSystem.entities.Admission;
import com.example.HospitalManagementSystem.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdmissionRepository extends JpaRepository<Admission, Long> {

        @Query("SELECT a FROM Admission a WHERE a.isActive=true")
        List<Admission> getAllAdmission();


        @Query("SELECT a FROM Admission a WHERE a.isActive=true AND a.id=:id")
        Admission getById(@Param("id") Long id);


    }
