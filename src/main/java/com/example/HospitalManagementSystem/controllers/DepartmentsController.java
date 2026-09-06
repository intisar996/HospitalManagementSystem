package com.example.HospitalManagementSystem.controllers;

import com.example.HospitalManagementSystem.entities.Departments;
import com.example.HospitalManagementSystem.entities.Hospital;
import com.example.HospitalManagementSystem.services.departmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("department")
public class DepartmentsController {

    departmentsService  departmentsService;
    @Autowired

    public DepartmentsController(departmentsService departmentsService) {
        this.departmentsService = departmentsService;
    }




    @PostMapping("add")
    public Long addDepartment(@RequestParam String name,@RequestParam String description,@RequestParam Long hospitalId) {
        return departmentsService.addDepartment(name,description,hospitalId);
    }


    @GetMapping("getAll")
    public List<Departments> getAllDepartments(){
        return departmentsService.getAllDepartments();
    }



    @GetMapping("getById")
    public Departments getById(@RequestParam Long id) {
        return departmentsService.getById(id);
    }


    @PutMapping("update")
    public Departments updateDepartments(@RequestParam Long id, @RequestParam String name,@RequestParam String description) throws Exception {
        return departmentsService.updateDepartment(id,name,description);
    }


    @PutMapping("deleteById")
    public Boolean deleteHospital(@RequestParam Long id) throws Exception {
        return departmentsService.deleteDepartment(id);

    }

}
