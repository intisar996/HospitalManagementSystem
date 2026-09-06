package com.example.HospitalManagementSystem.repositories;







import com.example.HospitalManagementSystem.entities.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicalRecordRepository extends JpaRepository<MedicalRecord,Long> {


    @Query("SELECT a FROM MedicalRecord a WHERE a.isActive=true")
    List<MedicalRecord> getAllMedicalRecord();


    @Query("SELECT a FROM MedicalRecord a WHERE a.isActive=true AND a.id=:id")
    MedicalRecord getById(@Param("id") Long id);
}
