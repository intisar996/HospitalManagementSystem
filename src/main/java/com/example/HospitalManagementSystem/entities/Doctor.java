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
public class Doctor extends  BaseClass {



    private String name;
    private String email;
    private String phoneNumber;
    private String specialization;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Appointment>  appointments;


}
