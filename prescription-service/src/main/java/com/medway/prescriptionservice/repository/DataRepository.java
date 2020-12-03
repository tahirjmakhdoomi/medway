package com.medway.prescriptionservice.repository;

import com.medway.prescriptionservice.model.PrescriptionData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DataRepository extends MongoRepository<PrescriptionData,String> {

    Optional<PrescriptionData> findByUsername(String username);
    void deleteByUsername(String username);
}
