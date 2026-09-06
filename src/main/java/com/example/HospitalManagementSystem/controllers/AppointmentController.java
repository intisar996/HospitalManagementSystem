package com.example.HospitalManagementSystem.controllers;

import com.example.HospitalManagementSystem.dto.AppointmentDTO;
import com.example.HospitalManagementSystem.services.AppointmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Long addAppointment(@Valid @RequestBody AppointmentDTO dto) {

        return appointmentService.addAppointment(
                dto.getAppointmentDate(),
                dto.getReason(),
                dto.getStatus(),
                dto.getPatientId(),
                dto.getDoctorId()
        );
    }

    @GetMapping("getAll")
    public List<AppointmentDTO> getAllAppointment() {

        List<AppointmentDTO> appointments =
                AppointmentDTO.convertToDTO(
                        appointmentService.getAllAppointment()
                );

        return appointments;
    }

    @GetMapping("getById")
    public AppointmentDTO getById(@RequestParam Long id) {

        return AppointmentDTO.convertToDTO(
                appointmentService.getById(id)
        );
    }

    @PutMapping("update")
    public AppointmentDTO updateAppointment(
            @Valid @RequestBody AppointmentDTO dto) throws Exception {

        return AppointmentDTO.convertToDTO(
                appointmentService.updateAppointment(
                        dto.getAppointmentId(),
                        dto.getAppointmentDate(),
                        dto.getReason(),
                        dto.getStatus()
                )
        );
    }

    @DeleteMapping("deleteById")
    public Boolean deleteAppointment(@RequestParam Long id) throws Exception {
        return appointmentService.deleteAppointment(id);
    }
}