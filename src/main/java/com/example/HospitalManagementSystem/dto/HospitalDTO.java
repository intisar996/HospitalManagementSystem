package com.example.HospitalManagementSystem.dto;

import com.example.HospitalManagementSystem.entities.Hospital;
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
public class HospitalDTO {

    @Positive
    private Long hospitalId;

    @NotBlank(message = "Hospital name cannot be blank")
    @Size(min = 3, max = 255, message = "Hospital name has to be between 3 and 255 characters")
    private String hospitalName;

    @NotBlank(message = "Hospital location cannot be blank")
    @Size(min = 3, max = 255, message = "Hospital location has to be between 3 and 255 characters")
    private String hospitalLocation;


    public static HospitalDTO convertToDTO(Hospital entity) {

        HospitalDTO dto = HospitalDTO.builder()
                .hospitalId(entity.getId())
                .hospitalName(entity.getName())
                .hospitalLocation(entity.getLocation())
                .build();

        return dto;
    }


    public static List<HospitalDTO> convertToDTO(List<Hospital> entityList) {

        List<HospitalDTO> dtos = new ArrayList<>();

        for (Hospital h : entityList) {
            dtos.add(convertToDTO(h));
        }

        return dtos;
    }
}