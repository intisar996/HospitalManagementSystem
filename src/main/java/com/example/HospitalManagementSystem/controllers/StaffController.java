package com.example.HospitalManagementSystem.controllers;

import com.example.HospitalManagementSystem.entities.Staff;
import com.example.HospitalManagementSystem.services.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Staff")
public class StaffController {

    StaffService staffService;

    @Autowired
    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @PostMapping("add")
    public Long addStaff(
            @RequestParam String name,
            @RequestParam String role,
            @RequestParam String phoneNumber,
            @RequestParam Long departmentId) {

        return staffService.addStaff(
                name,
                role,
                phoneNumber,
                departmentId
        );
    }

    @GetMapping("getAll")
    public List<Staff> getAllStaff() {
        return staffService.getAllStaff();
    }

    @GetMapping("getById")
    public Staff getById(@RequestParam Long id) {
        return staffService.getById(id);
    }

    @PutMapping("update")
    public Staff updateStaff(
            @RequestParam Long id,
            @RequestParam String name,
            @RequestParam String role,
            @RequestParam String phoneNumber) throws Exception {

        return staffService.updateStaff(
                id,
                name,
                role,
                phoneNumber
        );
    }

    @PutMapping("deleteById")
    public Boolean deleteStaff(@RequestParam Long id) throws Exception {
        return staffService.deleteStaff(id);
    }
}