package com.stackroute.orderservice.model;

public class OrderDetails {
    private String medicineName;
    private int quantity;
    private int finalPrice;
    private int supplierId;

    public OrderDetails(String medicineName, int quantity, int finalPrice, int supplierId) {
        this.medicineName = medicineName;
        this.quantity = quantity;
        this.finalPrice = finalPrice;
        this.supplierId = supplierId;
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

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }
}
