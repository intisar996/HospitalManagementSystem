package com.example.HospitalManagementSystem.services;


import com.example.HospitalManagementSystem.entities.*;
import com.example.HospitalManagementSystem.repositories.AppointmentRepository;
import com.example.HospitalManagementSystem.repositories.DoctorRepository;
import com.example.HospitalManagementSystem.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

   AppointmentRepository appointmentRepository;
   PatientRepository patientRepository;
   PatientService patientService;
   DoctorRepository doctorRepository;
   DoctorService doctorService;


    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository, DoctorRepository doctorRepository, DoctorService doctorService, PatientRepository patientRepository, PatientService patientService) {
        this.appointmentRepository = appointmentRepository;
        this.doctorRepository = doctorRepository;
        this.doctorService = doctorService;
        this.patientRepository = patientRepository;
        this.patientService = patientService;
    }





    public Long addAppointment(Date date, String reason,String status ,Long patientId,Long doctorId){

        Patient patient = patientService.getById(patientId);
        Doctor doctor = doctorService.getById(doctorId);


        if(patient == null || patient.getIsActive() == false){
            return -1L;
        }
        if(doctor == null || doctor.getIsActive() == false){
            return -1L;
        }




        Appointment appointment = new Appointment();
        appointment.setIsActive(true);
        appointment.setCreatedDate(new Date());
        appointment.setAppointmentDate(date);
        appointment.setReason(reason);
        appointment.setStatus(status);

        Appointment saveAppointment = appointmentRepository.save(appointment);

        List<Appointment> appointments = patient.getAppointments();
        List<Appointment> DoctorAppointments = doctor.getAppointments();
        appointments.add(saveAppointment);
        DoctorAppointments.add(saveAppointment);
        patient.setAppointments(appointments);
        doctor.setAppointments(DoctorAppointments);
        patientRepository.save(patient);
        doctorRepository.save(doctor);
        return appointment.getId();


    }


    public List<Appointment> getAllAppointment(){
        return  appointmentRepository.getAllAppointment();
    }


    public Appointment getById(Long id) {
        Optional<Appointment> appointment = appointmentRepository.findById(id);
        if (appointment.isPresent() && appointment.get().getIsActive()) {
            return appointment.get();
        }
        return new Appointment();
    }


    public Appointment updateAppointment(Long id, Date date, String reason,String status) throws Exception {
        Appointment appointmentToUpdate = appointmentRepository.getById(id);
        if (appointmentToUpdate == null) {
            throw new Exception("Hi Guys, Appointment is not found by the id");

        }
        appointmentToUpdate.setUpdateDate(new Date());
        appointmentToUpdate.setAppointmentDate(date);
        appointmentToUpdate.setStatus(status);
        appointmentToUpdate.setReason(reason);
        appointmentToUpdate = appointmentRepository.save(appointmentToUpdate);
        return appointmentToUpdate;
    }


    public Boolean  deleteAppointment(Long id) throws Exception {
        Appointment appointmentToUpdate = appointmentRepository.getById(id);
        if (appointmentToUpdate == null) {
            throw new Exception("Hi Guys, Appointment is not found by the id");

        }
        appointmentToUpdate.setUpdateDate(new Date());
        appointmentToUpdate.setIsActive(false);
        appointmentToUpdate = appointmentRepository.save(appointmentToUpdate);
        return true;
    }







}
