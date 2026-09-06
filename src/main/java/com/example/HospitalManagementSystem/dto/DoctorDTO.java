package com.example.HospitalManagementSystem.dto;

import com.example.HospitalManagementSystem.entities.Doctor;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class DoctorDTO {

    @Positive
    private Long doctorId;

    @NotBlank(message = "Doctor name cannot be blank")
    @Size(min = 3, max = 255, message = "Doctor name has to be between 3 and 255 characters")
    private String doctorName;

    @NotBlank(message = "Doctor email cannot be blank")
    @Email(message = "Email must be valid")
    @Size(max = 255, message = "Email cannot exceed 255 characters")
    private String email;

    @NotBlank(message = "Phone number cannot be blank")
    @Size(max = 255, message = "Phone number cannot exceed 255 characters")
    private String phoneNumber;

    @NotBlank(message = "Specialization cannot be blank")
    @Size(min = 2, max = 255, message = "Specialization has to be between 2 and 255 characters")
    private String specialization;

    @Positive
    private Long departmentId;


    public static DoctorDTO convertToDTO(Doctor entity) {

        DoctorDTO dto = DoctorDTO.builder()
                .doctorId(entity.getId())
                .doctorName(entity.getName())
                .email(entity.getEmail())
                .phoneNumber(entity.getPhoneNumber())
                .specialization(entity.getSpecialization())
                .build();

        return dto;
    }


    public static List<DoctorDTO> convertToDTO(List<Doctor> entityList) {

        List<DoctorDTO> dtos = new ArrayList<>();

        for (Doctor d : entityList) {
            dtos.add(convertToDTO(d));
        }

        return dtos;
    }
}