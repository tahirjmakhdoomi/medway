package com.stackroute.Medicine.Service.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/* Add Annotation to declare this class as a JPA Entity */

@Entity
@Table(name="Supplier")
public class Supplier {
    @Id

    private int SupplierId;
    private String SupplierName;
    private String LicenseNumber;


    public Supplier() {
    }



    public Supplier(int supplierId, String supplierName, String licenseNumber) {
        SupplierId = supplierId;
        SupplierName = supplierName;
        LicenseNumber = licenseNumber;


    }

    public int getSupplierId() {
        return SupplierId;
    }

    public void setSupplierId(int supplierId) {
        SupplierId = supplierId;
    }

    public String getSupplierName() {
        return SupplierName;
    }

    public void setSupplierName(String supplierName) {
        SupplierName = supplierName;
    }

    public String getLicenseNumber() {
        return LicenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        LicenseNumber = licenseNumber;
    }



    public class Store {

        private String name;
        private String city;
        private String state;
        private int pincode;

        public Store(String name, String city, String state, int pincode) {
            this.name = name;
            this.city = city;
            this.state = state;
            this.pincode = pincode;
        }

        public Store() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public int getPincode() {
            return pincode;
        }

        public void setPincode(int pincode) {
            this.pincode = pincode;
        }
    }

}
/*Add Annotation to declare this field as a Unique Identifier */


/* Generate no-arg and parametrized consructor */

