package com.example.HospitalManagementSystem.entities;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Entity
public class Bill extends BaseClass  {


    private Double amount;
    private String status;
    private Date billDate;



}
