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

public class Hospital extends  BaseClass {



     private String name;
     private String location;


     @OneToMany(cascade = CascadeType.ALL)
     private List<Departments> departments;


     @OneToMany(cascade = CascadeType.ALL)
     private List<Room> rooms;

     @OneToMany(cascade = CascadeType.ALL)
     private List<Patient> patients;


     @OneToMany(cascade = CascadeType.ALL)
     private List<Doctor> doctors;









}
