package com.example.HospitalManagementSystem.dto;

import com.example.HospitalManagementSystem.entities.Guardian;
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
public class GuardianDTO {

    @Positive
    private Long guardianId;

    @NotBlank(message = "Guardian name cannot be blank")
    @Size(min = 3, max = 255, message = "Guardian name has to be between 3 and 255 characters")
    private String name;

    @NotBlank(message = "Relationship cannot be blank")
    @Size(min = 2, max = 255, message = "Relationship has to be between 2 and 255 characters")
    private String relationship;

    @NotBlank(message = "Phone number cannot be blank")
    @Size(min = 8, max = 255, message = "Phone number has to be between 8 and 255 characters")
    private String phoneNumber;

    @Positive
    private Long patientId;


    public static GuardianDTO convertToDTO(Guardian entity) {

        return GuardianDTO.builder()
                .guardianId(entity.getId())
                .name(entity.getName())
                .relationship(entity.getRelationship())
                .phoneNumber(entity.getPhoneNumber())
                .build();
    }


    public static List<GuardianDTO> convertToDTO(List<Guardian> entityList) {

        List<GuardianDTO> dtos = new ArrayList<>();

        for (Guardian guardian : entityList) {
            dtos.add(convertToDTO(guardian));
        }

        return dtos;
    }
}