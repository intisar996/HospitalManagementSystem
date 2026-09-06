package com.example.HospitalManagementSystem.controllers;

import com.example.HospitalManagementSystem.dto.BillDTO;
import com.example.HospitalManagementSystem.services.BillService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Long addBill(@Valid @RequestBody BillDTO dto) {

        return billService.addBill(
                dto.getAmount(),
                dto.getStatus(),
                dto.getBillDate(),
                dto.getPatientId()
        );
    }

    @GetMapping("getAll")
    public List<BillDTO> getAllBill() {

        List<BillDTO> bills =
                BillDTO.convertToDTO(
                        billService.getAllBill()
                );

        return bills;
    }

    @GetMapping("getById")
    public BillDTO getById(@RequestParam Long id) {

        return BillDTO.convertToDTO(
                billService.getById(id)
        );
    }

    @PutMapping("update")
    public BillDTO updateBill(
            @Valid @RequestBody BillDTO dto) throws Exception {

        return BillDTO.convertToDTO(
                billService.updateBill(
                        dto.getBillId(),
                        dto.getAmount(),
                        dto.getStatus()
                )
        );
    }

    @DeleteMapping("deleteById")
    public Boolean deleteBill(@RequestParam Long id) throws Exception {
        return billService.deleteBill(id);
    }
}