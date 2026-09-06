package com.example.HospitalManagementSystem.controllers;

import com.example.HospitalManagementSystem.dto.AdmissionDTO;
import com.example.HospitalManagementSystem.services.AdmissionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Long addAdmission(@Valid @RequestBody AdmissionDTO dto) {
        return admissionService.addAdmission(
                dto.getAdmitDate(),
                dto.getDischargeDate(),
                dto.getPatientId(),
                dto.getRoomId()
        );
    }

    @GetMapping("getAll")
    public List<AdmissionDTO> getAllAdmission() {
        List<AdmissionDTO> admissions =
                AdmissionDTO.convertToDTO(admissionService.getAllAdmission());

        return admissions;
    }

    @GetMapping("getById")
    public AdmissionDTO getById(@RequestParam Long id) {
        return AdmissionDTO.convertToDTO(
                admissionService.getById(id)
        );
    }

    @PutMapping("update")
    public AdmissionDTO updateAdmission(
            @Valid @RequestBody AdmissionDTO dto) throws Exception {

        return AdmissionDTO.convertToDTO(
                admissionService.updateAdmission(
                        dto.getAdmissionId(),
                        dto.getDischargeDate()
                )
        );
    }

    @DeleteMapping("deleteById")
    public Boolean deleteAdmission(@RequestParam Long id) throws Exception {
        return admissionService.deleteAdmission(id);
    }
}