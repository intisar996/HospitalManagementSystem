package com.example.HospitalManagementSystem.services;

import com.example.HospitalManagementSystem.entities.*;
import com.example.HospitalManagementSystem.repositories.AdmissionRepository;
import com.example.HospitalManagementSystem.repositories.PatientRepository;
import com.example.HospitalManagementSystem.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class AdmissionService {


    AdmissionRepository admissionRepository;
    PatientService patientService;
    PatientRepository patientRepository;
    RoomService roomService;
    RoomRepository roomRepository;

    @Autowired

    public AdmissionService(AdmissionRepository admissionRepository, PatientRepository patientRepository, PatientService patientService, RoomRepository roomRepository, RoomService roomService) {
        this.admissionRepository = admissionRepository;
        this.patientRepository = patientRepository;
        this.patientService = patientService;
        this.roomRepository = roomRepository;
        this.roomService = roomService;
    }



    public Long addAdmission(Date admitDate, Date dischargeDate, Long patientId, Long roomId){

        Patient patient = patientService.getById(patientId);
        Room room = roomService.getById(roomId);


        if(patient == null || patient.getIsActive() == false){
            return -1L;
        }
        if(room == null || room.getIsActive() == false){
            return -1L;
        }




        Admission admission = new Admission();
        admission.setIsActive(true);
        admission.setCreatedDate(new Date());
        admission.setAdmitDate(admitDate);
        admission.setDischargeDate(dischargeDate);

        Admission saveAdmission = admissionRepository.save(admission);

        List<Admission> admissions = patient.getAdmissions();
        List<Admission> RoomAdmissions = room.getAdmissions();
        admissions.add(saveAdmission);
        RoomAdmissions.add(saveAdmission);
        patient.setAdmissions(admissions);
        room.setAdmissions(RoomAdmissions);
        patientRepository.save(patient);
        roomRepository.save(room);
        return admission.getId();


    }


    public List<Admission> getAllAdmission(){
        return  admissionRepository.getAllAdmission();
    }


    public Admission getById(Long id) {
        Optional<Admission> admission = admissionRepository.findById(id);
        if (admission.isPresent() && admission.get().getIsActive()) {
            return admission.get();
        }
        return new Admission();
    }


    public Admission updateAdmission(Long id, Date dischargeDate) throws Exception {
        Admission admissionToUpdate = admissionRepository.getById(id);
        if (admissionToUpdate == null) {
            throw new Exception("Hi Guys, Admission is not found by the id");

        }
        admissionToUpdate.setUpdateDate(new Date());
        admissionToUpdate.setDischargeDate(dischargeDate);
        admissionToUpdate = admissionRepository.save(admissionToUpdate);
        return admissionToUpdate;
    }


    public Boolean  deleteAdmission(Long id) throws Exception {
        Admission admissionToUpdate = admissionRepository.getById(id);
        if (admissionToUpdate == null) {
            throw new Exception("Hi Guys, Admission is not found by the id");

        }
        admissionToUpdate.setUpdateDate(new Date());
        admissionToUpdate.setIsActive(false);
        admissionToUpdate = admissionRepository.save(admissionToUpdate);
        return true;
    }
}
