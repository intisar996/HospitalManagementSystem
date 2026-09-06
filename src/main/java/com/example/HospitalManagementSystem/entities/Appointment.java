package com.example.HospitalManagementSystem.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Entity
public class Appointment extends  BaseClass {

    private Date appointmentDate;
    private String reason;
    private String status;



}
