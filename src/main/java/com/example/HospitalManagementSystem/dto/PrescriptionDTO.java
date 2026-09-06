package com.example.HospitalManagementSystem.dto;

import com.example.HospitalManagementSystem.entities.Prescription;
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
public class PrescriptionDTO {

    @Positive
    private Long prescriptionId;

    @NotBlank(message = "Medicine name cannot be blank")
    @Size(min = 2, max = 255, message = "Medicine name has to be between 2 and 255 characters")
    private String medicineName;

    @NotBlank(message = "Dosage cannot be blank")
    @Size(min = 1, max = 255, message = "Dosage has to be between 1 and 255 characters")
    private String dosage;

    @NotBlank(message = "Duration days cannot be blank")
    @Size(min = 1, max = 255, message = "Duration days has to be between 1 and 255 characters")
    private String durationDays;

    @Positive
    private Long medicalRecordId;


    public static PrescriptionDTO convertToDTO(Prescription entity) {

        return PrescriptionDTO.builder()
                .prescriptionId(entity.getId())
                .medicineName(entity.getMedicineName())
                .dosage(entity.getDosage())
                .durationDays(entity.getDurationDays())
                .build();
    }


    public static List<PrescriptionDTO> convertToDTO(List<Prescription> entityList) {

        List<PrescriptionDTO> dtos = new ArrayList<>();

        for (Prescription prescription : entityList) {
            dtos.add(convertToDTO(prescription));
        }

        return dtos;
    }
}

