package com.stackroute.Medicine.Service.domain;
import java.io.Serializable;
import java.util.Objects;

public class SupplierMedicineId implements Serializable {



    private String medicineName;
    private int supplierId;

    public SupplierMedicineId() {
    }

    public SupplierMedicineId(String medicineName, int supplierId) {
        this.medicineName = medicineName;
        this.supplierId = supplierId;
    }
    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SupplierMedicineId supplierMedicineId = (SupplierMedicineId) o;
        return medicineName.equals(supplierMedicineId.medicineName) &&
                (supplierId == (supplierMedicineId.supplierId));
    }

    @Override
    public int hashCode() {
        return Objects.hash(medicineName, supplierId);
    }
}