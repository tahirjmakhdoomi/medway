package com.medway.prescriptionservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.common.aliasing.qual.Unique;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;

@Entity
//@NoArgsConstructor
//@Data
//@AllArgsConstructor
public class PrescriptionData {
    @Id @Unique
    private String username;
    @Embedded
    private ArrayList<Prescriptions> prescriptions;

    public PrescriptionData(@Unique String username, ArrayList<Prescriptions> prescriptions) {
        this.username = username;
        this.prescriptions = prescriptions;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ArrayList<Prescriptions> getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(Prescriptions prescriptions) {
        this.prescriptions.add(prescriptions);
    }
}
