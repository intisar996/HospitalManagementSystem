package com.example.HospitalManagementSystem.dto;

import com.example.HospitalManagementSystem.entities.Patient;
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
public class PatientDTO {

    @Positive
    private Long patientId;

    @NotBlank(message = "Patient name cannot be blank")
    @Size(min = 3, max = 255, message = "Patient name has to be between 3 and 255 characters")
    private String patientName;

    @NotBlank(message = "Gender cannot be blank")
    @Size(max = 255, message = "Gender cannot exceed 255 characters")
    private String gender;

    @NotBlank(message = "Phone number cannot be blank")
    @Size(max = 255, message = "Phone number cannot exceed 255 characters")
    private String phoneNumber;

    @NotBlank(message = "Blood group cannot be blank")
    @Size(max = 255, message = "Blood group cannot exceed 255 characters")
    private String bloodGroup;


    public static PatientDTO convertToDTO(Patient entity) {

        PatientDTO dto = PatientDTO.builder()
                .patientId(entity.getId())
                .patientName(entity.getName())
                .gender(entity.getGender())
                .phoneNumber(entity.getPhoneNumber())
                .bloodGroup(entity.getBloodGroup())
                .build();

        return dto;
    }


    public static List<PatientDTO> convertToDTO(List<Patient> entityList) {

        List<PatientDTO> dtos = new ArrayList<>();

        for (Patient p : entityList) {
            dtos.add(convertToDTO(p));
        }

        return dtos;
    }
}