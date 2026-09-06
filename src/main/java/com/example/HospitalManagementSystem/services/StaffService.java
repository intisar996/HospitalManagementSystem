package com.example.HospitalManagementSystem.services;

import com.example.HospitalManagementSystem.entities.Departments;
import com.example.HospitalManagementSystem.entities.Staff;
import com.example.HospitalManagementSystem.repositories.DepartmentsRepository;
import com.example.HospitalManagementSystem.repositories.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class StaffService {

    StaffRepository staffRepository;
    departmentsService departmentsService;
    DepartmentsRepository departmentsRepository;

    @Autowired
    public StaffService(
            StaffRepository staffRepository,
            departmentsService departmentsService,
            DepartmentsRepository departmentsRepository) {

        this.staffRepository = staffRepository;
        this.departmentsService = departmentsService;
        this.departmentsRepository = departmentsRepository;
    }

    public Long addStaff(
            String name,
            String role,
            String phoneNumber,
            Long departmentId) {

        Departments department = departmentsService.getById(departmentId);

        if (department == null || department.getIsActive() == false) {
            return -1L;
        }

        Staff staff = new Staff();

        staff.setIsActive(true);
        staff.setCreatedDate(new Date());
        staff.setName(name);
        staff.setRole(role);
        staff.setPhoneNumber(phoneNumber);

        Staff saveStaff = staffRepository.save(staff);

        List<Staff> staffList = department.getStaffList();
        staffList.add(saveStaff);
        department.setStaffList(staffList);

        departmentsRepository.save(department);

        return staff.getId();
    }

    public List<Staff> getAllStaff() {
        return staffRepository.getAllStaff();
    }

    public Staff getById(Long id) {

        Optional<Staff> staff = staffRepository.findById(id);

        if (staff.isPresent() && staff.get().getIsActive()) {
            return staff.get();
        }

        return new Staff();
    }

    public Staff updateStaff(
            Long id,
            String name,
            String role,
            String phoneNumber) throws Exception {

        Staff staffToUpdate = staffRepository.getById(id);

        if (staffToUpdate == null) {
            throw new Exception("Staff is not found by the id");
        }

        staffToUpdate.setUpdateDate(new Date());
        staffToUpdate.setName(name);
        staffToUpdate.setRole(role);
        staffToUpdate.setPhoneNumber(phoneNumber);

        return staffRepository.save(staffToUpdate);
    }

    public Boolean deleteStaff(Long id) throws Exception {

        Staff staffToUpdate = staffRepository.getById(id);

        if (staffToUpdate == null) {
            throw new Exception("Staff is not found by the id");
        }

        staffToUpdate.setUpdateDate(new Date());
        staffToUpdate.setIsActive(false);

        staffRepository.save(staffToUpdate);

        return true;
    }
}