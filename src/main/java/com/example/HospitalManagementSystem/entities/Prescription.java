package com.example.HospitalManagementSystem.entities;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Prescription extends  BaseClass {

    private String medicineName;
    private String dosage;
    private String durationDays;

}
