package com.example.HospitalManagementSystem.controllers;


import com.example.HospitalManagementSystem.dto.PrescriptionDTO;
import com.example.HospitalManagementSystem.services.PrescriptionService;
import jakarta.validation.Valid;
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
    public Long addPrescription(@Valid @RequestBody PrescriptionDTO dto) {

        return prescriptionService.addPrescription(
                dto.getMedicineName(),
                dto.getDosage(),
                dto.getDurationDays(),
                dto.getMedicalRecordId()
        );
    }


    @GetMapping("getAll")
    public List<PrescriptionDTO> getAllPrescriptions() {

        return PrescriptionDTO.convertToDTO(
                prescriptionService.getAllPrescriptions()
        );
    }


    @GetMapping("getById")
    public PrescriptionDTO getById(@RequestParam Long id) {

        return PrescriptionDTO.convertToDTO(
                prescriptionService.getById(id)
        );
    }


    @PutMapping("update")
    public PrescriptionDTO updatePrescription(
            @Valid @RequestBody PrescriptionDTO dto) throws Exception {

        return PrescriptionDTO.convertToDTO(
                prescriptionService.updatePrescription(
                        dto.getPrescriptionId(),
                        dto.getDosage(),
                        dto.getDurationDays()
                )
        );
    }


    @DeleteMapping("deleteById")
    public Boolean deletePrescription(@RequestParam Long id) throws Exception {

        return prescriptionService.deletePrescription(id);
    }
}

