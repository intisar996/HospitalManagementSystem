package com.example.HospitalManagementSystem.entities;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@Entity
public class MedicalRecord extends BaseClass{

    private String diagnosis;
    private String notes;
    private Date recordDate;


    @OneToMany(cascade = CascadeType.ALL)
    private List<Prescription> prescriptions;



}
