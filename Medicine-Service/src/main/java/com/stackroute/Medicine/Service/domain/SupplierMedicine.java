package com.stackroute.Medicine.Service.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="SupplierMedicine")
//@IdClass(SupplierMedicineId.class)

public class SupplierMedicine {
        @EmbeddedId
        private CompositeKey compositeKey;
        private float price;
        private float discount;
        private int stock;
        private LocalDate manufactureDate;
        private LocalDate expDate;

        public SupplierMedicine() {
        }

        public SupplierMedicine(CompositeKey compositeKey, float price, float discount, int stock, LocalDate manufactureDate, LocalDate expDate) {
                this.compositeKey = compositeKey;
                this.price = price;
                this.discount = discount;
                this.stock = stock;
                this.manufactureDate = manufactureDate;
                this.expDate = expDate;
        }

        public CompositeKey getCompositeKey() {
                return compositeKey;
        }

        public void setCompositeKey(CompositeKey compositeKey) {
                this.compositeKey = compositeKey;
        }

        public float getPrice() {
                return price;
        }

        public void setPrice(float price) {
                this.price = price;
        }

        public float getDiscount() {
                return discount;
        }

        public void setDiscount(float discount) {
                this.discount = discount;
        }

        public int getStock() {
                return stock;
        }

        public void setStock(int stock) {
                this.stock = stock;
        }

        public LocalDate getManufactureDate() {
                return manufactureDate;
        }

        public void setManufactureDate(LocalDate manufactureDate) {
                this.manufactureDate = manufactureDate;
        }

        public LocalDate getExpDate() {
                return expDate;
        }

        public void setExpDate(LocalDate expDate) {
                this.expDate = expDate;
        }
}


