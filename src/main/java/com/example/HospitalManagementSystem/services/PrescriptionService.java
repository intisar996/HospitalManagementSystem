package com.example.HospitalManagementSystem.services;


import com.example.HospitalManagementSystem.entities.MedicalRecord;
import com.example.HospitalManagementSystem.entities.Prescription;
import com.example.HospitalManagementSystem.repositories.MedicalRecordRepository;
import com.example.HospitalManagementSystem.repositories.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PrescriptionService {

    PrescriptionRepository prescriptionRepository;
    MedicalRecordService medicalRecordService;
    MedicalRecordRepository medicalRecordRepository;

   @Autowired
    public PrescriptionService(MedicalRecordRepository medicalRecordRepository, MedicalRecordService medicalRecordService, PrescriptionRepository prescriptionRepository) {
        this.medicalRecordRepository = medicalRecordRepository;
        this.medicalRecordService = medicalRecordService;
        this.prescriptionRepository = prescriptionRepository;
    }

    public Long addPrescription(String medicineName, String dosage, String durationDays , Long  medicalRecordId){

        MedicalRecord medicalRecord = medicalRecordService.getById(medicalRecordId);

        if(medicalRecord == null || medicalRecord.getIsActive() == false){
            return -1L;
        }

        Prescription prescription = new Prescription();
        prescription.setIsActive(true);
        prescription.setCreatedDate(new Date());
        prescription.setDosage(dosage);
        prescription.setMedicineName(medicineName);
        prescription.setDurationDays(durationDays);


        Prescription savePrescription = prescriptionRepository.save(prescription);

        List<Prescription> prescriptions = medicalRecord.getPrescriptions();
        prescriptions.add(savePrescription);
        medicalRecord.setPrescriptions(prescriptions);
        medicalRecordRepository.save(medicalRecord);
        return prescription.getId();

    }


    public List<Prescription> getAllPrescriptions(){
        return  prescriptionRepository.getAllPrescriptions();
    }


    public Prescription getById(Long id) {
        Optional<Prescription> prescription = prescriptionRepository.findById(id);
        if (prescription.isPresent() && prescription.get().getIsActive()) {
            return prescription.get();
        }
        return new Prescription();
    }


    public Prescription updatePrescription(Long id, String dosage, String durationDays) throws Exception {
        Prescription perscriptionRecordToUpdate = prescriptionRepository.getById(id);
        if (perscriptionRecordToUpdate == null) {
            throw new Exception("Hi Guys, Prescription is not found by the id");

        }
        perscriptionRecordToUpdate.setUpdateDate(new Date());
        perscriptionRecordToUpdate.setDosage(dosage);
        perscriptionRecordToUpdate.setDurationDays(durationDays);
        perscriptionRecordToUpdate = prescriptionRepository.save(perscriptionRecordToUpdate);
        return perscriptionRecordToUpdate;
    }


    public Boolean  deletePrescription(Long id) throws Exception {
        Prescription perscriptionRecordToUpdate = prescriptionRepository.getById(id);
        if (perscriptionRecordToUpdate == null) {
            throw new Exception("Hi Guys, Prescription is not found by the id");

        }
        perscriptionRecordToUpdate.setUpdateDate(new Date());
        perscriptionRecordToUpdate.setIsActive(false);
        perscriptionRecordToUpdate = prescriptionRepository.save(perscriptionRecordToUpdate);
        return true;
    }

}
