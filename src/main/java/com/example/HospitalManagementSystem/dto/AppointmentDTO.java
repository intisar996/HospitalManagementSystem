package com.example.HospitalManagementSystem.dto;

import com.example.HospitalManagementSystem.entities.Appointment;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class AppointmentDTO {

    @Positive
    private Long appointmentId;

    private Date appointmentDate;

    @NotBlank(message = "Reason cannot be blank")
    @Size(max = 255, message = "Reason cannot exceed 255 characters")
    private String reason;

    @NotBlank(message = "Status cannot be blank")
    @Size(max = 255, message = "Status cannot exceed 255 characters")
    private String status;

    @Positive
    private Long patientId;

    @Positive
    private Long doctorId;


    public static AppointmentDTO convertToDTO(Appointment entity) {

        AppointmentDTO dto = AppointmentDTO.builder()
                .appointmentId(entity.getId())
                .appointmentDate(entity.getAppointmentDate())
                .reason(entity.getReason())
                .status(entity.getStatus())
                .build();

        return dto;
    }


    public static List<AppointmentDTO> convertToDTO(List<Appointment> entityList) {

        List<AppointmentDTO> dtos = new ArrayList<>();

        for (Appointment a : entityList) {
            dtos.add(convertToDTO(a));
        }

        return dtos;
    }
}