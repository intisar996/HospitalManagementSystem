package com.example.HospitalManagementSystem.controllers;

import com.example.HospitalManagementSystem.dto.DepartmentsDTO;
import com.example.HospitalManagementSystem.services.departmentsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("department")
public class DepartmentsController {

    departmentsService departmentsService;

    @Autowired
    public DepartmentsController(departmentsService departmentsService) {
        this.departmentsService = departmentsService;
    }

    @PostMapping("add")
    public Long addDepartment(@Valid @RequestBody DepartmentsDTO dto) {

        return departmentsService.addDepartment(
                dto.getDepartmentName(),
                dto.getDescription(),
                dto.getHospitalId()
        );
    }

    @GetMapping("getAll")
    public List<DepartmentsDTO> getAllDepartments() {

        List<DepartmentsDTO> departments =
                DepartmentsDTO.convertToDTO(
                        departmentsService.getAllDepartments()
                );

        return departments;
    }

    @GetMapping("getById")
    public DepartmentsDTO getById(@RequestParam Long id) {

        return DepartmentsDTO.convertToDTO(
                departmentsService.getById(id)
        );
    }

    @PutMapping("update")
    public DepartmentsDTO updateDepartments(
            @Valid @RequestBody DepartmentsDTO dto) throws Exception {

        return DepartmentsDTO.convertToDTO(
                departmentsService.updateDepartment(
                        dto.getDepartmentId(),
                        dto.getDepartmentName(),
                        dto.getDescription()
                )
        );
    }

    @DeleteMapping("deleteById")
    public Boolean deleteDepartment(@RequestParam Long id) throws Exception {
        return departmentsService.deleteDepartment(id);
    }
}