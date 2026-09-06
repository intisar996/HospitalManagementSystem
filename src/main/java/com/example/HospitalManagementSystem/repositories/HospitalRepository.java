package com.example.HospitalManagementSystem.repositories;


import com.example.HospitalManagementSystem.entities.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital,Long> {




       @Query("SELECT h FROM Hospital h WHERE h.isActive=true")
       List<Hospital> getAllHospital();


    @Query("SELECT h FROM Hospital h WHERE h.isActive=true AND h.id=:id")
    Hospital getById(@Param("id") Long id);



}
