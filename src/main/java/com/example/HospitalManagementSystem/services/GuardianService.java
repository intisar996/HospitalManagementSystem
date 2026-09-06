package com.example.HospitalManagementSystem.services;

import com.example.HospitalManagementSystem.entities.Guardian;
import com.example.HospitalManagementSystem.entities.Patient;
import com.example.HospitalManagementSystem.repositories.GuardianRepository;
import com.example.HospitalManagementSystem.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class GuardianService {

    GuardianRepository guardianRepository;
    PatientService patientService;
    PatientRepository patientRepository;

    @Autowired
    public GuardianService(
            GuardianRepository guardianRepository,
            PatientService patientService,
            PatientRepository patientRepository) {

        this.guardianRepository = guardianRepository;
        this.patientService = patientService;
        this.patientRepository = patientRepository;
    }

    public Long addGuardian(
            String name,
            String relationship,
            String phoneNumber,
            Long patientId) {

        Patient patient = patientService.getById(patientId);

        if (patient == null || patient.getIsActive() == false) {
            return -1L;
        }

        Guardian guardian = new Guardian();

        guardian.setIsActive(true);
        guardian.setCreatedDate(new Date());
        guardian.setName(name);
        guardian.setRelationship(relationship);
        guardian.setPhoneNumber(phoneNumber);

        Guardian saveGuardian = guardianRepository.save(guardian);

        List<Guardian> guardianList = patient.getGuardians();
        guardianList.add(saveGuardian);
        patient.setGuardians(guardianList);

        patientRepository.save(patient);

        return guardian.getId();
    }

    public List<Guardian> getAllGuardian() {
        return guardianRepository.getAllGuardian();
    }

    public Guardian getById(Long id) {

        Optional<Guardian> guardian = guardianRepository.findById(id);

        if (guardian.isPresent() && guardian.get().getIsActive()) {
            return guardian.get();
        }

        return new Guardian();
    }

    public Guardian updateGuardian(
            Long id,
            String name,
            String relationship,
            String phoneNumber) throws Exception {

        Guardian guardianToUpdate = guardianRepository.getById(id);

        if (guardianToUpdate == null) {
            throw new Exception("Guardian is not found by the id");
        }

        guardianToUpdate.setUpdateDate(new Date());
        guardianToUpdate.setName(name);
        guardianToUpdate.setRelationship(relationship);
        guardianToUpdate.setPhoneNumber(phoneNumber);

        return guardianRepository.save(guardianToUpdate);
    }

    public Boolean deleteGuardian(Long id) throws Exception {

        Guardian guardianToUpdate = guardianRepository.getById(id);

        if (guardianToUpdate == null) {
            throw new Exception("Guardian is not found by the id");
        }

        guardianToUpdate.setUpdateDate(new Date());
        guardianToUpdate.setIsActive(false);

        guardianRepository.save(guardianToUpdate);

        return true;
    }
}