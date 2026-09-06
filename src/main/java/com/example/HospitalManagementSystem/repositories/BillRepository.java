package com.example.HospitalManagementSystem.repositories;


import com.example.HospitalManagementSystem.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {

    @Query("SELECT a FROM Bill a WHERE a.isActive=true")
    List<Bill> getAllBill();


    @Query("SELECT a FROM Bill a WHERE a.isActive=true AND a.id=:id")
    Bill getById(@Param("id") Long id);


}
