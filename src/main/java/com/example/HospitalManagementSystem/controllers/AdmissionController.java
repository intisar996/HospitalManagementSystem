package com.example.HospitalManagementSystem.controllers;

import com.example.HospitalManagementSystem.entities.Admission;
import com.example.HospitalManagementSystem.entities.Departments;
import com.example.HospitalManagementSystem.services.AdmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;



@RestController
@RequestMapping("Admission")
public class AdmissionController {



    AdmissionService admissionService;

    @Autowired
    public AdmissionController(AdmissionService admissionService) {
        this.admissionService = admissionService;
    }

    @PostMapping("add")
    public Long addAdmission(@RequestParam Date admitDate, @RequestParam Date dischargeDate, @RequestParam Long patientId , @RequestParam Long roomId) {
        return admissionService.addAdmission(admitDate,dischargeDate,patientId,roomId);
    }


    @GetMapping("getAll")
    public List<Admission> getAllAdmission(){
        return admissionService.getAllAdmission();
    }



    @GetMapping("getById")
    public Admission getById(@RequestParam Long id) {
        return admissionService.getById(id);
    }


    @PutMapping("update")
    public Admission updateAdmission(@RequestParam Long id, @RequestParam Date dischargeDate) throws Exception {
        return admissionService.updateAdmission(id,dischargeDate);
    }


    @PutMapping("deleteById")
    public Boolean deleteAdmission(@RequestParam Long id) throws Exception {
        return admissionService.deleteAdmission(id);

    }
}
