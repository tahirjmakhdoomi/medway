package com.stackroute.Medicine.Service.domain;

import  java.io.Serializable;
import javax.persistence.Embeddable;
@Embeddable

public class CompositeKey implements Serializable
{
    private  String supplierName;
    private String medicineName;

    public CompositeKey() {
    }

    public CompositeKey(String supplierName, String medicineName) {
        this.supplierName = supplierName;
        this.medicineName = medicineName;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }
}
