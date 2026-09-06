package com.example.HospitalManagementSystem.entities;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity

public class Departments extends  BaseClass {


    private String name;
    private String description;


    @OneToMany(cascade = CascadeType.ALL)
    private List<Doctor> doctors;


    @OneToMany(cascade = CascadeType.ALL)
    private List<Staff> staffList;




}
