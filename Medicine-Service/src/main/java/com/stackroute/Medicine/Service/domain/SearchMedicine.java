package com.stackroute.Medicine.Service.domain;

import java.time.LocalDate;

public class SearchMedicine {
    private String MedicineName ="";
    private String SupplierName ="";
    private float Price =0;
    private float Discount =0;
    private int Stock =0;
    private LocalDate ManufactureDate =null;
    private LocalDate ExpDate =null;

    public String getMedicineName() {
        return MedicineName;
    }

    public void setMedicineName(String medicineName) {
        MedicineName = medicineName;
    }

    public String getSupplierName() {
        return SupplierName;
    }

    public void setSupplierName(String supplierName) {
        SupplierName = supplierName;
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
