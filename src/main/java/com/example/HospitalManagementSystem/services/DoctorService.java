package com.example.HospitalManagementSystem.services;



import com.example.HospitalManagementSystem.entities.Departments;
import com.example.HospitalManagementSystem.entities.Doctor;
import com.example.HospitalManagementSystem.entities.Hospital;
import com.example.HospitalManagementSystem.repositories.DepartmentsRepository;
import com.example.HospitalManagementSystem.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    DoctorRepository doctorRepository;
    departmentsService departmentsService;
    DepartmentsRepository departmentsRepository;

    @Autowired
    public DoctorService(DepartmentsRepository departmentsRepository, departmentsService departmentsService, DoctorRepository doctorRepository) {
        this.departmentsRepository = departmentsRepository;
        this.departmentsService = departmentsService;
        this.doctorRepository = doctorRepository;
    }

    public Long addDoctor(String name, String email, String phoneNumber, String specialization, Long departmentId){

        Departments departments = departmentsRepository.getById(departmentId);
        if(departments == null || departments.getIsActive() == false){
            return -1L;
        }

        Doctor doctor = new Doctor();
        doctor.setIsActive(true);
        doctor.setCreatedDate(new Date());
        doctor.setName(name);
        doctor.setEmail(email);
        doctor.setPhoneNumber(phoneNumber);
        doctor.setSpecialization(specialization);

        Doctor saveDoctor = doctorRepository.save(doctor);

        List<Doctor> doctors = departments.getDoctors();
        doctors.add(saveDoctor);
        departments.setDoctors(doctors);
        departmentsRepository.save(departments);
        return doctor.getId();


    }


    public List<Doctor> getAllDoctor(){
        return  doctorRepository.getAllDoctors();
    }


    public Doctor getById(Long id) {
        Optional<Doctor> doctor = doctorRepository.findById(id);
        if (doctor.isPresent() && doctor.get().getIsActive()) {
            return doctor.get();
        }
        return new Doctor();
    }


    public Doctor updateDoctor(Long id, String name, String email, String phoneNumber, String specialization) throws Exception {
        Doctor doctorToUpdate = doctorRepository.getById(id);
        if (doctorToUpdate == null) {
            throw new Exception("Hi Guys, Doctor is not found by the id");

        }
        doctorToUpdate.setUpdateDate(new Date());
        doctorToUpdate.setName(name);
        doctorToUpdate.setEmail(email);
        doctorToUpdate.setPhoneNumber(phoneNumber);
        doctorToUpdate.setSpecialization(specialization);
        doctorToUpdate = doctorRepository.save(doctorToUpdate);
        return doctorToUpdate;
    }


    public Boolean  deleteDoctor(Long id) throws Exception {
        Doctor doctorToUpdate = doctorRepository.getById(id);
        if (doctorToUpdate == null) {
            throw new Exception("Hi Guys, Doctor is not found by the id");

        }
        doctorToUpdate.setUpdateDate(new Date());
        doctorToUpdate.setIsActive(false);
        doctorToUpdate = doctorRepository.save(doctorToUpdate);
        return true;
    }

}
