package com.medway.prescriptionservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicineModel {
    private String medicineName;
    private int SupplierId;
    private LocalDate manufactureDate;
    private LocalDate expDate;
    private int stock;
    private int discount;
    private int price;
    private int finalPrice;
}
