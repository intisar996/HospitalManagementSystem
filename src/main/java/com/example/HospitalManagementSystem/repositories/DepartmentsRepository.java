package com.example.HospitalManagementSystem.repositories;


import com.example.HospitalManagementSystem.entities.Departments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentsRepository  extends JpaRepository<Departments,Long> {


    @Query("SELECT d FROM Departments d WHERE d.isActive=true")
    List<Departments> getAllDepartments();


    @Query("SELECT d FROM Departments d WHERE d.isActive=true AND d.id=:id")
    Departments getById(@Param("id") Long id);
}
