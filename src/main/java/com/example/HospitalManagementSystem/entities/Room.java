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
public class Room  extends  BaseClass{

    private Integer roomNumber;
    private Integer floor;
    private String type;
    private Integer capacity;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Admission> admissions;





}
