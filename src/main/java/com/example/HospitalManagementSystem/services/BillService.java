package com.example.HospitalManagementSystem.services;

import com.example.HospitalManagementSystem.entities.*;
import com.example.HospitalManagementSystem.repositories.AdmissionRepository;
import com.example.HospitalManagementSystem.repositories.BillRepository;
import com.example.HospitalManagementSystem.repositories.PatientRepository;
import com.example.HospitalManagementSystem.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class BillService {


    BillRepository billRepository;
    PatientService patientService;
    PatientRepository patientRepository;

    @Autowired

    public BillService(BillRepository billRepository, PatientRepository patientRepository, PatientService patientService) {
        this.billRepository = billRepository;
        this.patientRepository = patientRepository;
        this.patientService = patientService;

    }




    public Long addBill(Double amount, String status,Date billDate, Long patientId){

        Patient patient = patientService.getById(patientId);


        if(patient == null || patient.getIsActive() == false){
            return -1L;
        }

        Bill bill = new Bill();
        bill.setIsActive(true);
        bill.setCreatedDate(new Date());
        bill.setAmount(amount);
        bill.setStatus(status);
        bill.setBillDate(billDate);

        Bill saveBill = billRepository.save(bill);

        List<Bill> billList = patient.getBill();
        billList.add(saveBill);
        patient.setBill(billList);
        patientRepository.save(patient);
        return bill.getId();


    }


    public List<Bill> getAllBill(){
        return  billRepository.getAllBill();
    }


    public Bill getById(Long id) {
        Optional<Bill> bill = billRepository.findById(id);
        if (bill.isPresent() && bill.get().getIsActive()) {
            return bill.get();
        }
        return new Bill();
    }


    public Bill updateBill(Long id,Double amount, String status) throws Exception {
        Bill billToUpdate = billRepository.getById(id);
        if (billToUpdate == null) {
            throw new Exception("Hi Guys, Bill is not found by the id");

        }
        billToUpdate.setUpdateDate(new Date());
        billToUpdate.setAmount(amount);
        billToUpdate.setStatus(status);

        billToUpdate = billRepository.save(billToUpdate);
        return billToUpdate;
    }


    public Boolean  deleteBill(Long id) throws Exception {
        Bill billToUpdate = billRepository.getById(id);
        if (billToUpdate == null) {
            throw new Exception("Hi Guys, Bill is not found by the id");

        }
        billToUpdate.setUpdateDate(new Date());
        billToUpdate.setIsActive(false);
        billToUpdate = billRepository.save(billToUpdate);
        return true;
    }
}
