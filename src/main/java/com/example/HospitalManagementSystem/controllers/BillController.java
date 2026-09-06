package com.example.HospitalManagementSystem.controllers;

import com.example.HospitalManagementSystem.entities.Bill;
import com.example.HospitalManagementSystem.services.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("Bill")
public class BillController {

    BillService billService;

    @Autowired
    public BillController(BillService billService) {
        this.billService = billService;
    }

    @PostMapping("add")
    public Long addBill(
            @RequestParam Double amount,
            @RequestParam String status,
            @RequestParam Date billDate,
            @RequestParam Long patientId) {

        return billService.addBill(
                amount,
                status,
                billDate,
                patientId
        );
    }

    @GetMapping("getAll")
    public List<Bill> getAllBill() {
        return billService.getAllBill();
    }

    @GetMapping("getById")
    public Bill getById(@RequestParam Long id) {
        return billService.getById(id);
    }

    @PutMapping("update")
    public Bill updateBill(
            @RequestParam Long id,
            @RequestParam Double amount,
            @RequestParam String status) throws Exception {

        return billService.updateBill(id, amount, status);
    }

    @PutMapping("deleteById")
    public Boolean deleteBill(@RequestParam Long id) throws Exception {
        return billService.deleteBill(id);
    }
}