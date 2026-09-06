package com.example.HospitalManagementSystem.controllers;

import com.example.HospitalManagementSystem.dto.MedicalRecordDTO;
import com.example.HospitalManagementSystem.services.MedicalRecordService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Long addMedicalRecord(@Valid @RequestBody MedicalRecordDTO dto) {

        return medicalRecordService.addMedicalRecord(
                dto.getDiagnosis(),
                dto.getNotes(),
                dto.getRecordDate(),
                dto.getPatientId()
        );
    }


    @GetMapping("getAll")
    public List<MedicalRecordDTO> getAllMedicalRecord() {

        return MedicalRecordDTO.convertToDTO(
                medicalRecordService.getAllMedicalRecord()
        );
    }


    @GetMapping("getById")
    public MedicalRecordDTO getById(@RequestParam Long id) {

        return MedicalRecordDTO.convertToDTO(
                medicalRecordService.getById(id)
        );
    }


    @PutMapping("update")
    public MedicalRecordDTO updateMedicalRecord(
            @Valid @RequestBody MedicalRecordDTO dto) throws Exception {

        return MedicalRecordDTO.convertToDTO(
                medicalRecordService.updateMedicalRecord(
                        dto.getMedicalRecordId(),
                        dto.getDiagnosis(),
                        dto.getNotes()
                )
        );
    }


    @DeleteMapping("deleteById")
    public Boolean deleteMedicalRecord(@RequestParam Long id) throws Exception {

        return medicalRecordService.deleteMedicalRecord(id);
    }
}

