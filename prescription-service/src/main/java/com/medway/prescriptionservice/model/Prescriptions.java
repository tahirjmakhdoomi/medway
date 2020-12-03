package com.medway.prescriptionservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Embeddable
public class Prescriptions {
    private Long prescriptionId;
    private String prescriptionContent;
    private List<String> detectedMedicines;
    private String prescriptionPDFLink;
}
