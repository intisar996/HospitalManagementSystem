package com.example.HospitalManagementSystem.dto;

import com.example.HospitalManagementSystem.entities.Bill;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class BillDTO {

    @Positive
    private Long billId;

    @Positive
    private Double amount;

    @NotBlank(message = "Status cannot be blank")
    @Size(max = 255, message = "Status cannot exceed 255 characters")
    private String status;

    private Date billDate;

    @Positive
    private Long patientId;


    public static BillDTO convertToDTO(Bill entity) {

        BillDTO dto = BillDTO.builder()
                .billId(entity.getId())
                .amount(entity.getAmount())
                .status(entity.getStatus())
                .billDate(entity.getBillDate())
                .build();

        return dto;
    }


    public static List<BillDTO> convertToDTO(List<Bill> entityList) {

        List<BillDTO> dtos = new ArrayList<>();

        for (Bill b : entityList) {
            dtos.add(convertToDTO(b));
        }

        return dtos;
    }
}