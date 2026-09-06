package com.example.HospitalManagementSystem.services;


import com.example.HospitalManagementSystem.entities.Departments;
import com.example.HospitalManagementSystem.entities.Hospital;
import com.example.HospitalManagementSystem.repositories.DepartmentsRepository;
import com.example.HospitalManagementSystem.repositories.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class departmentsService {


    DepartmentsRepository departmentsRepository;
    hospitalService hospitalService;
    HospitalRepository hospitalRepository;
    @Autowired
    public departmentsService(DepartmentsRepository departmentsRepository, HospitalRepository hospitalRepository, hospitalService hospitalService) {
        this.departmentsRepository = departmentsRepository;
        this.hospitalRepository = hospitalRepository;
        this.hospitalService = hospitalService;
    }






    public Long addDepartment(String name, String description,Long hospitalId){

        Hospital hospital = hospitalService.getById(hospitalId);
        if(hospital == null || hospital.getIsActive() == false){
            return -1L;
        }
        Departments departments = new Departments();
        departments.setIsActive(true);
        departments.setCreatedDate(new Date());
        departments.setName(name);
        departments.setDescription(description);

        Departments saveDepartments = departmentsRepository.save(departments);

        List<Departments> departmentsList = hospital.getDepartments();
        departmentsList.add(saveDepartments);
        hospital.setDepartments(departmentsList);
        hospitalRepository.save(hospital);
        return departments.getId();


    }


    public List<Departments> getAllDepartments(){
        return  departmentsRepository.getAllDepartments();
    }


    public Departments getById(Long id) {
        Optional<Departments> departments = departmentsRepository.findById(id);
        if (departments.isPresent() && departments.get().getIsActive()) {
            return departments.get();
        }
        return new Departments();
    }


    public Departments updateDepartment(Long id, String name, String description) throws Exception {
        Departments departmentsToUpdate = departmentsRepository.getById(id);
        if (departmentsToUpdate == null) {
            throw new Exception("Hi Guys, Department is not found by the id");

        }
        departmentsToUpdate.setUpdateDate(new Date());
        departmentsToUpdate.setName(name);
        departmentsToUpdate.setDescription(description);
        departmentsToUpdate = departmentsRepository.save(departmentsToUpdate);
        return departmentsToUpdate;
    }


    public Boolean  deleteDepartment(Long id) throws Exception {
        Departments departmentsToUpdate = departmentsRepository.getById(id);
        if (departmentsToUpdate == null) {
            throw new Exception("Hi Guys, Department is not found by the id");

        }
        departmentsToUpdate.setUpdateDate(new Date());
        departmentsToUpdate.setIsActive(false);
        departmentsToUpdate = departmentsRepository.save(departmentsToUpdate);
        return true;
    }




}
