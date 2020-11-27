package com.stackroute.Medicine.Service.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name="SupplierMedicine")
//@IdClass(SupplierMedicineId.class)

public class SupplierMedicine {

    @Id
    private String MedicineName;
   // @Id
    private int SupplierId;
    private float Price;
    private float Discount;
    private int Stock;
    private LocalDate ManufactureDate;
    private LocalDate ExpDate;
    public SupplierMedicine() {
    }

    public SupplierMedicine(int supplierId, String medicineName, float price, float discount, int stock, LocalDate manufactureDate, LocalDate expDate) {
        SupplierId = supplierId;
        MedicineName = medicineName;
        Price = price;
        Discount = discount;
        Stock = stock;
        ManufactureDate = manufactureDate;
        ExpDate = expDate;
    }

    public int getSupplierId() {
        return SupplierId;
    }

    public void setSupplierId(int supplierId) {
        SupplierId = supplierId;
    }

    public String getMedicineName() {
        return MedicineName;
    }

    public void setMedicineName(String medicineName) {
        MedicineName = medicineName;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float price) {
        Price = price;
    }

    public float getDiscount() {
        return Discount;
    }

    public void setDiscount(float discount) {
        Discount = discount;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int stock) {
        Stock = stock;
    }

    public LocalDate getManufactureDate() {
        return ManufactureDate;
    }

    public void setManufactureDate(LocalDate manufactureDate) {
        ManufactureDate = manufactureDate;
    }

    public LocalDate getExpDate() {
        return ExpDate;
    }

    public void setExpDate(LocalDate expDate) {
        ExpDate = expDate;
    }
}

