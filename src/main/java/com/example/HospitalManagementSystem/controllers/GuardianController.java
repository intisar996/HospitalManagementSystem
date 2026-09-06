package com.example.HospitalManagementSystem.controllers;

import com.example.HospitalManagementSystem.entities.Guardian;
import com.example.HospitalManagementSystem.services.GuardianService;
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
    public Long addGuardian(
            @RequestParam String name,
            @RequestParam String relationship,
            @RequestParam String phoneNumber,
            @RequestParam Long patientId) {

        return guardianService.addGuardian(
                name,
                relationship,
                phoneNumber,
                patientId
        );
    }

    @GetMapping("getAll")
    public List<Guardian> getAllGuardian() {
        return guardianService.getAllGuardian();
    }

    @GetMapping("getById")
    public Guardian getById(@RequestParam Long id) {
        return guardianService.getById(id);
    }

    @PutMapping("update")
    public Guardian updateGuardian(
            @RequestParam Long id,
            @RequestParam String name,
            @RequestParam String relationship,
            @RequestParam String phoneNumber) throws Exception {

        return guardianService.updateGuardian(
                id,
                name,
                relationship,
                phoneNumber
        );
    }

    @PutMapping("deleteById")
    public Boolean deleteGuardian(@RequestParam Long id) throws Exception {
        return guardianService.deleteGuardian(id);
    }
}