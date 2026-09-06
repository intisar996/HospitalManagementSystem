package com.example.HospitalManagementSystem.controllers;


import com.example.HospitalManagementSystem.dto.HospitalDTO;
import com.example.HospitalManagementSystem.entities.Hospital;
import com.example.HospitalManagementSystem.services.hospitalService;
import jakarta.validation.Valid;
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
    public Long addHospital(@Valid  @RequestParam String name, @RequestParam String location) {
        return hospitalService.addHospital(name,location);
    }


    @GetMapping("getAll")
    public List<HospitalDTO> getAllHospital(){
        List<HospitalDTO> hospitalDTOList = HospitalDTO.convertToDTO(hospitalService.getAllHospital());
        return hospitalDTOList;
    }



    @GetMapping("getById")
    public HospitalDTO getById(@RequestParam Long id) {
        return HospitalDTO.convertToDTO(hospitalService.getById(id));
    }


    @PutMapping("update")
    public HospitalDTO updateHospital(@Valid  @RequestParam  HospitalDTO dto) throws Exception {
        return HospitalDTO.convertToDTO(hospitalService.updateHospital(dto.getHospitalId(),dto.getHospitalName(),dto.getHospitalLocation())) ;
    }


    @PutMapping("deleteById")
    public Boolean deleteHospital(@RequestParam Long id) throws Exception {
        return hospitalService.deleteHospital(id);
    }


}
