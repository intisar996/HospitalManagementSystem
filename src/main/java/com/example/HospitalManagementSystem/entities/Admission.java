package com.example.HospitalManagementSystem.entities;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Entity
public class Admission extends  BaseClass{

    private Date admitDate;
    private Date dischargeDate;

}
