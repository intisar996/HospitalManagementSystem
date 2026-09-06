package com.example.HospitalManagementSystem.controllers;


import com.example.HospitalManagementSystem.entities.Departments;
import com.example.HospitalManagementSystem.entities.MedicalRecord;
import com.example.HospitalManagementSystem.services.MedicalRecordService;
import com.example.HospitalManagementSystem.services.departmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("medical-record")
public class MedicalRecordController {

    MedicalRecordService medicalRecordService;


    @Autowired
    public MedicalRecordController(MedicalRecordService medicalRecordService) {
        this.medicalRecordService = medicalRecordService;
    }








    @PostMapping("add")
    public Long addMedicalRecord(String diagnosis, String notes, Date recordDate , Long patientId) {
        return medicalRecordService.addMedicalRecord(diagnosis,notes,recordDate,patientId);
    }


    @GetMapping("getAll")
    public List<MedicalRecord> getAllMedicalRecord(){
        return medicalRecordService.getAllMedicalRecord();
    }



    @GetMapping("getById")
    public MedicalRecord getById(@RequestParam Long id) {
        return medicalRecordService.getById(id);
    }


    @PutMapping("update")
    public MedicalRecord updateMedicalRecord(@RequestParam Long id, @RequestParam String diagnosis,@RequestParam String notes) throws Exception {
        return medicalRecordService.updateMedicalRecord(id,diagnosis,notes);
    }


    @PutMapping("deleteById")
    public Boolean deleteMedicalRecord(@RequestParam Long id) throws Exception {
        return medicalRecordService.deleteMedicalRecord(id);

    }


}
