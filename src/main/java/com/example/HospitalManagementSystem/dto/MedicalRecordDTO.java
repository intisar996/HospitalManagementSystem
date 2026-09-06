package com.example.HospitalManagementSystem.dto;


import com.example.HospitalManagementSystem.entities.MedicalRecord;
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
public class MedicalRecordDTO {

    @Positive
    private Long medicalRecordId;

    @NotBlank(message = "Diagnosis cannot be blank")
    @Size(min = 3, max = 255, message = "Diagnosis has to be between 3 and 255 characters")
    private String diagnosis;

    @NotBlank(message = "Notes cannot be blank")
    @Size(min = 3, max = 255, message = "Notes has to be between 3 and 255 characters")
    private String notes;

    private Date recordDate;

    @Positive
    private Long patientId;


    public static MedicalRecordDTO convertToDTO(MedicalRecord entity) {

        return MedicalRecordDTO.builder()
                .medicalRecordId(entity.getId())
                .diagnosis(entity.getDiagnosis())
                .notes(entity.getNotes())
                .recordDate(entity.getRecordDate())
                .build();
    }


    public static List<MedicalRecordDTO> convertToDTO(List<MedicalRecord> entityList) {

        List<MedicalRecordDTO> dtos = new ArrayList<>();

        for (MedicalRecord medicalRecord : entityList) {
            dtos.add(convertToDTO(medicalRecord));
        }

        return dtos;
    }
}

