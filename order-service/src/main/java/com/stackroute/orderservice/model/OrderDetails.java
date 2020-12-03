package com.stackroute.orderservice.model;

public class OrderDetails {
    private String medicineName;
    private int quantity;
    private int finalPrice;
    private String supplierName;

    public OrderDetails(String medicineName, int quantity, int finalPrice, String supplierName) {
        this.medicineName = medicineName;
        this.quantity = quantity;
        this.finalPrice = finalPrice;
        this.supplierName = supplierName;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(int finalPrice) {
        this.finalPrice = finalPrice;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }
}
