package com.example.HospitalManagementSystem.controllers;


import com.example.HospitalManagementSystem.entities.Prescription;
import com.example.HospitalManagementSystem.services.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("prescription")

public class PrescriptionController {


    PrescriptionService prescriptionService;


    @Autowired
    public PrescriptionController(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }


    @PostMapping("add")
    public Long addPrescription(@RequestParam String medicineName, @RequestParam String dosage, @RequestParam String durationDays, @RequestParam Long medicalRecordId) {
        return prescriptionService.addPrescription(medicineName, dosage, durationDays, medicalRecordId);
    }


    @GetMapping("getAll")
    public List<Prescription> getAllPrescriptions() {
        return prescriptionService.getAllPrescriptions();
    }


    @GetMapping("getById")
    public Prescription getById(@RequestParam Long id) {
        return prescriptionService.getById(id);
    }


    @PutMapping("update")
    public Prescription updatePrescription(@RequestParam Long id, @RequestParam String dosage, @RequestParam String durationDays) throws Exception {
        return prescriptionService.updatePrescription(id, dosage, durationDays);
    }


    @PutMapping("deleteById")
    public Boolean deletePrescription(@RequestParam Long id) throws Exception {
        return prescriptionService.deletePrescription(id);

    }
}