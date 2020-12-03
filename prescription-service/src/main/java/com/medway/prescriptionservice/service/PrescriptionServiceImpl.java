package com.medway.prescriptionservice.service;

import com.medway.prescriptionservice.model.PrescriptionData;
import com.medway.prescriptionservice.model.Prescriptions;
import com.medway.prescriptionservice.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PrescriptionServiceImpl implements PrescriptionService{
    @Autowired
    private DataRepository dr;

    @Override
    public PrescriptionData addPrescription(String username, Prescriptions prescriptions) {
        Optional<PrescriptionData> pd = dr.findByUsername(username);
        if(pd.isPresent()){
            PrescriptionData temp = pd.get();
            temp.setPrescriptions(prescriptions);
            dr.deleteByUsername(pd.get().getUsername());
            return dr.save(temp);
        }
        else {
            ArrayList<Prescriptions> p = new ArrayList<>();
            p.add(prescriptions);
            return dr.save(new PrescriptionData(username,p));
        }
    }

    @Override
    public List<Prescriptions> getPrescription(String username) {
        Optional<PrescriptionData> pd = dr.findByUsername(username);
        if(pd.isPresent()) return pd.get().getPrescriptions();
        else{
            return new ArrayList<>();
        }
    }


}
