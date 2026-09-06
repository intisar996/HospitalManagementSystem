package com.example.HospitalManagementSystem.services;


import com.example.HospitalManagementSystem.entities.Appointment;
import com.example.HospitalManagementSystem.entities.Doctor;
import com.example.HospitalManagementSystem.entities.MedicalRecord;
import com.example.HospitalManagementSystem.entities.Patient;
import com.example.HospitalManagementSystem.repositories.MedicalRecordRepository;
import com.example.HospitalManagementSystem.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MedicalRecordService {

    MedicalRecordRepository medicalRecordRepository;
    PatientService patientService;
    PatientRepository patientRepository;
    @Autowired
    public MedicalRecordService(MedicalRecordRepository medicalRecordRepository, PatientRepository patientRepository, PatientService patientService) {
        this.medicalRecordRepository = medicalRecordRepository;
        this.patientRepository = patientRepository;
        this.patientService = patientService;
    }




    public Long addMedicalRecord(String diagnosis, String notes,Date recordDate ,Long patientId){

        Patient patient = patientService.getById(patientId);

        if(patient == null || patient.getIsActive() == false){
            return -1L;
        }

        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setIsActive(true);
        medicalRecord.setCreatedDate(new Date());
        medicalRecord.setDiagnosis(diagnosis);
        medicalRecord.setNotes(notes);
        medicalRecord.setRecordDate(recordDate);

        MedicalRecord saveMedicalRecord = medicalRecordRepository.save(medicalRecord);

        List<MedicalRecord> medicalRecords = patient.getMedicalRecords();
        medicalRecords.add(saveMedicalRecord);
        patient.setMedicalRecords(medicalRecords);
        patientRepository.save(patient);
        return medicalRecord.getId();

    }


    public List<MedicalRecord> getAllMedicalRecord(){
        return  medicalRecordRepository.getAllMedicalRecord();
    }


    public MedicalRecord getById(Long id) {
        Optional<MedicalRecord> medicalRecord = medicalRecordRepository.findById(id);
        if (medicalRecord.isPresent() && medicalRecord.get().getIsActive()) {
            return medicalRecord.get();
        }
        return new MedicalRecord();
    }


    public MedicalRecord updateMedicalRecord(Long id, String diagnosis, String notes) throws Exception {
        MedicalRecord medicalRecordToUpdate = medicalRecordRepository.getById(id);
        if (medicalRecordToUpdate == null) {
            throw new Exception("Hi Guys, MedicalRecord is not found by the id");

        }
        medicalRecordToUpdate.setUpdateDate(new Date());
        medicalRecordToUpdate.setDiagnosis(diagnosis);
        medicalRecordToUpdate.setNotes(notes);
        medicalRecordToUpdate = medicalRecordRepository.save(medicalRecordToUpdate);
        return medicalRecordToUpdate;
    }


    public Boolean  deleteMedicalRecord(Long id) throws Exception {
        MedicalRecord medicalRecordToUpdate = medicalRecordRepository.getById(id);
        if (medicalRecordToUpdate == null) {
            throw new Exception("Hi Guys, MedicalRecord is not found by the id");

        }
        medicalRecordToUpdate.setUpdateDate(new Date());
        medicalRecordToUpdate.setIsActive(false);
        medicalRecordToUpdate = medicalRecordRepository.save(medicalRecordToUpdate);
        return true;
    }


}
