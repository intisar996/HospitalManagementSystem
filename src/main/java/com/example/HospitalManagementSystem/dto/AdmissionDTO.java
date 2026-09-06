package com.example.HospitalManagementSystem.dto;

import com.example.HospitalManagementSystem.entities.Admission;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class AdmissionDTO {

    @Positive
    private Long admissionId;

    private Date admitDate;

    private Date dischargeDate;

    @Positive
    private Long patientId;

    @Positive
    private Long roomId;


    public static AdmissionDTO convertToDTO(Admission entity) {

        AdmissionDTO dto = AdmissionDTO.builder()
                .admissionId(entity.getId())
                .admitDate(entity.getAdmitDate())
                .dischargeDate(entity.getDischargeDate())
                .build();

        return dto;
    }


    public static List<AdmissionDTO> convertToDTO(List<Admission> entityList) {

        List<AdmissionDTO> dtos = new ArrayList<>();

        for (Admission a : entityList) {
            dtos.add(convertToDTO(a));
        }

        return dtos;
    }
}