package com.example.HospitalManagementSystem.controllers;


import com.example.HospitalManagementSystem.entities.Departments;
import com.example.HospitalManagementSystem.entities.Doctor;
import com.example.HospitalManagementSystem.services.DoctorService;
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
    public Long addDoctor(@RequestParam String name,@RequestParam String email,@RequestParam String phoneNumber, @RequestParam String specialization,@RequestParam Long departmentId) {
        return doctorService.addDepartment(name,email,phoneNumber,specialization,departmentId);
    }

    @GetMapping("getAll")
    public List<Doctor> getAllDoctor(){
        return doctorService.getAllDoctor();
    }



    @GetMapping("getById")
    public Doctor getById(@RequestParam Long id) {
        return doctorService.getById(id);
    }


    @PutMapping("update")
    public Doctor updateDepartments(@RequestParam Long id,@RequestParam String name,@RequestParam String email, @RequestParam String phoneNumber, @RequestParam String specialization) throws Exception {
        return doctorService.updateDoctor(id,name,email,phoneNumber,specialization);
    }


    @PutMapping("deleteById")
    public Boolean deleteHospital(@RequestParam Long id) throws Exception {
        return doctorService.deleteDoctor(id);

    }
}
