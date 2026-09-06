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
public class Patient extends  BaseClass {

    private String name;
    private String gender;
    private String phoneNumber;
    private String bloodGroup;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Appointment> appointments;

    @OneToMany(cascade = CascadeType.ALL)
    private List<MedicalRecord>  medicalRecords;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Guardian>  guardians;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Admission>  admissions;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Bill>  bill;

}
