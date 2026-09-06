package com.example.HospitalManagementSystem.entities;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Guardian extends  BaseClass{

    private String name;
    private String relationship;
    private String phoneNumber;

}
