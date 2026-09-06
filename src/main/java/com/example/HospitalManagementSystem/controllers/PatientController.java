package com.example.HospitalManagementSystem.controllers;


import com.example.HospitalManagementSystem.entities.Patient;
import com.example.HospitalManagementSystem.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("patient")

public class PatientController {


    PatientService patientService;

    @Autowired

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }



    @PostMapping("add")
    public Long addPatient(@RequestParam String name, @RequestParam String gender,@RequestParam String phoneNumber,@RequestParam String bloodGroup) {
        return patientService.addPatient(name,gender,phoneNumber,bloodGroup);
    }


    @GetMapping("getAll")
    public List<Patient> getAllPatients(){
        return patientService.getAllPatient();
    }



    @GetMapping("getById")
    public Patient getById(@RequestParam Long id) {
        return patientService.getById(id);
    }


    @PutMapping("update")
    public Patient updatePatient(@RequestParam Long id, @RequestParam String name,@RequestParam String phoneNumber) throws Exception {
        return patientService.updatePatient(id,name,phoneNumber);
    }


    @PutMapping("deleteById")
    public Boolean deletePatient(@RequestParam Long id) throws Exception {
        return patientService.deletePatient(id);

    }




}
