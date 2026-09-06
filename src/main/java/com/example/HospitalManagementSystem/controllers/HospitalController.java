package com.example.HospitalManagementSystem.controllers;


import com.example.HospitalManagementSystem.entities.Hospital;
import com.example.HospitalManagementSystem.services.hospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("hospital")
public class HospitalController {

    hospitalService hospitalService;


    @Autowired
    public HospitalController(hospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }



    @PostMapping("add")
    public Long addHospital(@RequestParam String name,@RequestParam String location) {
        return hospitalService.addHospital(name,location);
    }


    @GetMapping("getAll")
    public List<Hospital> getAllHospital(){
        return hospitalService.getAllHospital();
    }



    @GetMapping("getById")
    public Hospital getById(@RequestParam Long id) {
        return hospitalService.getById(id);
    }


    @PutMapping("update")
    public Hospital updateHospital(@RequestParam Long id, @RequestParam String name,@RequestParam String location) throws Exception {
        return hospitalService.updateHospital(id,name,location);
    }


    @PutMapping("deleteById")
    public Boolean deleteHospital(@RequestParam Long id) throws Exception {
        return hospitalService.deleteHospital(id);
    }


}
