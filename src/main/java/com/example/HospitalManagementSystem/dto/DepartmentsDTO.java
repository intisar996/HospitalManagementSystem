package com.example.HospitalManagementSystem.dto;

import com.example.HospitalManagementSystem.entities.Departments;
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
public class DepartmentsDTO {

    @Positive
    private Long departmentId;

    @NotBlank(message = "Department name cannot be blank")
    @Size(min = 3, max = 255, message = "Department name has to be between 3 and 255 characters")
    private String departmentName;

    @NotBlank(message = "Department description cannot be blank")
    @Size(min = 3, max = 255, message = "Department description has to be between 3 and 255 characters")
    private String description;

    @Positive
    private Long hospitalId;


    public static DepartmentsDTO convertToDTO(Departments entity) {

        DepartmentsDTO dto = DepartmentsDTO.builder()
                .departmentId(entity.getId())
                .departmentName(entity.getName())
                .description(entity.getDescription())
                .build();

        return dto;
    }


    public static List<DepartmentsDTO> convertToDTO(List<Departments> entityList) {

        List<DepartmentsDTO> dtos = new ArrayList<>();

        for (Departments d : entityList) {
            dtos.add(convertToDTO(d));
        }

        return dtos;
    }
}