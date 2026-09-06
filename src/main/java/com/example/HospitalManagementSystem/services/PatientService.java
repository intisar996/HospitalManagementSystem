package com.example.HospitalManagementSystem.services;


import com.example.HospitalManagementSystem.entities.Departments;
import com.example.HospitalManagementSystem.entities.Doctor;
import com.example.HospitalManagementSystem.entities.Hospital;
import com.example.HospitalManagementSystem.entities.Patient;
import com.example.HospitalManagementSystem.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {



    PatientRepository patientRepository;


    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Long addPatient(String name, String gender,String phoneNumber,String bloodGroup){

        Patient patient = new Patient();
        patient.setIsActive(true);
        patient.setCreatedDate(new Date());
        patient.setName(name);
        patient.setGender(gender);
        patient.setPhoneNumber(phoneNumber);
        patient.setBloodGroup(bloodGroup);
        Patient patient1 = patientRepository.save(patient);
        return patient1.getId();


    }


    public List<Patient> getAllPatient(){
        return  patientRepository.getAllPatients();
    }


    public Patient getById(Long id) {
        Optional<Patient> patient = patientRepository.findById(id);
        if (patient.isPresent() && patient.get().getIsActive()) {
            return patient.get();
        }
        return new Patient();
    }


    public Patient updatePatient(Long id, String name, String phoneNumber) throws Exception {
        Patient patientToUpdate = patientRepository.getById(id);
        if (patientToUpdate == null) {
            throw new Exception("Hi Guys, Patient is not found by the id");

        }
        patientToUpdate.setUpdateDate(new Date());
        patientToUpdate.setName(name);
        patientToUpdate.setPhoneNumber(phoneNumber);
        patientToUpdate = patientRepository.save(patientToUpdate);
        return patientToUpdate;
    }


    public Boolean  deletePatient(Long id) throws Exception {
        Patient patientToUpdate = patientRepository.getById(id);
        if (patientToUpdate == null) {
            throw new Exception("Hi Guys, Patient is not found by the id");

        }
        patientToUpdate.setUpdateDate(new Date());
        patientToUpdate.setIsActive(false);
        patientToUpdate = patientRepository.save(patientToUpdate);
        return true;
    }



}
