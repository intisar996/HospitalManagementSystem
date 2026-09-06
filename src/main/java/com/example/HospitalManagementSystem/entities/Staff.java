package com.example.HospitalManagementSystem.entities;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Staff extends BaseClass {

    private String name;
    private String role;
    private String phoneNumber;
}
