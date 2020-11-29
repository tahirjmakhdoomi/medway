package com.stackroute.Medicine.Service.domain;

import java.time.LocalDate;

public class SearchMedicine {
    public String MedicineName = null;
    public int SupplierId = 0;
    public float Price = 0;
    public float Discount = 0;
    public int Stock = 0;
    public LocalDate ManufactureDate = null;
    public LocalDate ExpDate = null;
    public float FinalPrice = 0;

    public SearchMedicine() {
    }

    public SearchMedicine(String medicineName, int supplierId, float price, float discount, int stock, LocalDate manufactureDate, LocalDate expDate, float finalPrice) {
        MedicineName = medicineName;
        SupplierId = supplierId;
        Price = price;
        Discount = discount;
        Stock = stock;
        ManufactureDate = manufactureDate;
        ExpDate = expDate;
        FinalPrice = finalPrice;
    }

    public String getMedicineName() {

        return MedicineName;
    }

    public void setMedicineName(String medicineName) {
        MedicineName = medicineName;
    }

    public int getSupplierId() {
        return SupplierId;
    }

    public void setSupplierId(int supplierId) {
        SupplierId = supplierId;
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

    public float getFinalPrice() {
        return FinalPrice;
    }

    public void setFinalPrice(float finalPrice) {
        FinalPrice = finalPrice;
    }
}
