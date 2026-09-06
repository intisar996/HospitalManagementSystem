package com.example.HospitalManagementSystem.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class hospitalDTO {



    private Long hospitalId;
    private String name;
    private String location;





}
