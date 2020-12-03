package com.medway.prescriptionservice.service;

import com.medway.prescriptionservice.model.PrescriptionData;
import com.medway.prescriptionservice.model.Prescriptions;

import java.util.ArrayList;
import java.util.List;

public interface PrescriptionService {
    public PrescriptionData addPrescription(String username, Prescriptions prescriptions);
    public List<Prescriptions> getPrescription(String username);
}
