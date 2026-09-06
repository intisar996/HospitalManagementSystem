package com.example.HospitalManagementSystem.controllers;


import com.example.HospitalManagementSystem.dto.PatientDTO;
import com.example.HospitalManagementSystem.entities.Patient;
import com.example.HospitalManagementSystem.services.PatientService;
import jakarta.validation.Valid;
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
    public Long addPatient(@Valid  @RequestParam String name, @RequestParam String gender, @RequestParam String phoneNumber, @RequestParam String bloodGroup) {
        return patientService.addPatient(name,gender,phoneNumber,bloodGroup);
    }


    @GetMapping("getAll")
    public List<PatientDTO> getAllPatients(){
        return PatientDTO.convertToDTO(patientService.getAllPatient());
    }



    @GetMapping("getById")
    public PatientDTO getById(@RequestParam Long id) {
        return PatientDTO.convertToDTO(patientService.getById(id));
    }


    @PutMapping("update")
    public PatientDTO updatePatient(@Valid @RequestParam Long id,  PatientDTO dto) throws Exception {

        return PatientDTO.convertToDTO(patientService.updatePatient(dto.getPatientId(),
                dto.getPatientName(),
                dto.getPhoneNumber()));
    }


    @PutMapping("deleteById")
    public Boolean deletePatient(@RequestParam Long id) throws Exception {
        return patientService.deletePatient(id);

    }




}
