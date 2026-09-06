package com.example.HospitalManagementSystem.services;


import com.example.HospitalManagementSystem.entities.Hospital;
import com.example.HospitalManagementSystem.repositories.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class hospitalService {

    HospitalRepository hospitalRepository;

    @Autowired

    public hospitalService(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }


    public Long addHospital(String name,String location){
        Hospital hospital = new Hospital();
        hospital.setIsActive(true);
        hospital.setCreatedDate(new Date());
        hospital.setName(name);
        hospital.setLocation(location);

        hospital = hospitalRepository.save(hospital);
        return hospital.getId();



    }


    public List<Hospital> getAllHospital(){
        return  hospitalRepository.getAllHospital();
    }


    public Hospital getById(Long id) {
        Optional<Hospital> hospital = hospitalRepository.findById(id);
        if (hospital.isPresent() && hospital.get().getIsActive()) {
            return hospital.get();
        }
        return new Hospital();
    }


    public Hospital updateHospital(Long id, String name, String location) throws Exception {
        Hospital hospitalToUpdate = hospitalRepository.getById(id);
        if (hospitalToUpdate == null) {
            throw new Exception("Hi Guys, Hospital is not found by the id");

        }
        hospitalToUpdate.setUpdateDate(new Date());
        hospitalToUpdate.setName(name);
        hospitalToUpdate.setLocation(location);
        hospitalToUpdate = hospitalRepository.save(hospitalToUpdate);
        return hospitalToUpdate;
    }


    public Boolean  deleteHospital(Long id) throws Exception {
        Hospital hospitalToUpdate = hospitalRepository.getById(id);
        if (hospitalToUpdate == null) {
            throw new Exception("Hi Guys, Hospital is not found by the id");

        }
        hospitalToUpdate.setUpdateDate(new Date());
        hospitalToUpdate.setIsActive(false);
        hospitalToUpdate = hospitalRepository.save(hospitalToUpdate);
        return true;
    }




}
