package com.example.HospitalManagementSystem.controllers;


import com.example.HospitalManagementSystem.dto.DoctorDTO;
import com.example.HospitalManagementSystem.entities.Departments;
import com.example.HospitalManagementSystem.entities.Doctor;
import com.example.HospitalManagementSystem.services.DoctorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("doctor")
public class DoctorController {


    DoctorService doctorService;

    @Autowired

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }


    @PostMapping("add")
    public Long addDoctor(@Valid @RequestParam String name, @RequestParam String email, @RequestParam String phoneNumber, @RequestParam String specialization, @RequestParam Long departmentId) {
        return doctorService.addDoctor(name,email,phoneNumber,specialization,departmentId);
    }

    @GetMapping("getAll")
    public List<DoctorDTO> getAllDoctor(){
        return DoctorDTO.convertToDTO(doctorService.getAllDoctor());
    }



    @GetMapping("getById")
    public DoctorDTO getById(@RequestParam Long id) {
        return DoctorDTO.convertToDTO(doctorService.getById(id)) ;
    }


    @PutMapping("update")
    public DoctorDTO updateDoctor(@Valid @RequestBody DoctorDTO dto) throws Exception {

        return DoctorDTO.convertToDTO(
                doctorService.updateDoctor(
                        dto.getDoctorId(),
                        dto.getDoctorName(),
                        dto.getEmail(),
                        dto.getPhoneNumber(),
                        dto.getSpecialization()
                )
        );
    }


    @PutMapping("deleteById")
    public Boolean deleteHospital(@RequestParam Long id) throws Exception {
        return doctorService.deleteDoctor(id);

    }
}
