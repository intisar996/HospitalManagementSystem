package com.example.HospitalManagementSystem.controllers;


import com.example.HospitalManagementSystem.entities.Appointment;
import com.example.HospitalManagementSystem.entities.Departments;
import com.example.HospitalManagementSystem.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("appointment")
public class AppointmentController {


     AppointmentService appointmentService;
    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }




    @PostMapping("add")
    public Long addAppointment(@RequestParam Date date,@RequestParam String reason, @RequestParam String status ,@RequestParam  Long patientId,@RequestParam Long doctorId) {
        return appointmentService.addAppointment(date,reason,status,patientId,doctorId);
    }


    @GetMapping("getAll")
    public List<Appointment> getAllAppointment(){
        return appointmentService.getAllAppointment();
    }



    @GetMapping("getById")
    public Appointment getById(@RequestParam Long id) {
        return appointmentService.getById(id);
    }


    @PutMapping("update")
    public Appointment updateAppointment(@RequestParam Long id,@RequestParam  Date date, @RequestParam String reason, @RequestParam String status) throws Exception {
        return appointmentService.updateAppointment(id,date,reason,status);
    }


    @PutMapping("deleteById")
    public Boolean deleteAppointment(@RequestParam Long id) throws Exception {
        return appointmentService.deleteAppointment(id);

    }









}
