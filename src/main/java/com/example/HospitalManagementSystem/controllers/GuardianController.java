package com.example.HospitalManagementSystem.controllers;

import com.example.HospitalManagementSystem.dto.GuardianDTO;
import com.example.HospitalManagementSystem.services.GuardianService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Guardian")
public class GuardianController {

    GuardianService guardianService;

    @Autowired
    public GuardianController(GuardianService guardianService) {
        this.guardianService = guardianService;
    }

    @PostMapping("add")
    public Long addGuardian(@Valid @RequestBody GuardianDTO dto) {

        return guardianService.addGuardian(
                dto.getName(),
                dto.getRelationship(),
                dto.getPhoneNumber(),
                dto.getPatientId()
        );
    }

    @GetMapping("getAll")
    public List<GuardianDTO> getAllGuardian() {

        return GuardianDTO.convertToDTO(
                guardianService.getAllGuardian()
        );
    }

    @GetMapping("getById")
    public GuardianDTO getById(@RequestParam Long id) {

        return GuardianDTO.convertToDTO(
                guardianService.getById(id)
        );
    }

    @PutMapping("update")
    public GuardianDTO updateGuardian(
            @Valid @RequestBody GuardianDTO dto) throws Exception {

        return GuardianDTO.convertToDTO(
                guardianService.updateGuardian(
                        dto.getGuardianId(),
                        dto.getName(),
                        dto.getRelationship(),
                        dto.getPhoneNumber()
                )
        );
    }

    @DeleteMapping("deleteById")
    public Boolean deleteGuardian(@RequestParam Long id) throws Exception {

        return guardianService.deleteGuardian(id);
    }
}