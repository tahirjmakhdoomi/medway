package com.stackroute.Medicine.Service.controller;


import com.stackroute.Medicine.Service.domain.SearchMedicine;
import com.stackroute.Medicine.Service.domain.SupplierMedicine;
import com.stackroute.Medicine.Service.service.SupplierMedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/* Add annotation to declare this class as REST Controller */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1")
public class SupplierMedicineController {
    private SupplierMedicineService supplierMedicineService;

    @Autowired
    public SupplierMedicineController(SupplierMedicineService supplierMedicineServiceService) {
        this.supplierMedicineService = supplierMedicineServiceService;
    }


    @PostMapping("/blogr")
    public ResponseEntity<SupplierMedicine> saveSupplierMedicine(@RequestBody SupplierMedicine supplierMedicine) {
        return new ResponseEntity<>(supplierMedicineService.saveSupplierMedicine(supplierMedicine), HttpStatus.OK);
    }

    @GetMapping("/blogs/{id}")
    public ResponseEntity<List<SupplierMedicine>> getSupplierMedicineById(@PathVariable("id") String id){
        return new ResponseEntity<List<SupplierMedicine>>(supplierMedicineService.getSupplierNameByRawQuery1(id), HttpStatus.OK
        );
    }

    @PostMapping("/blogs/raw2")
    public ResponseEntity<?> getSupplierNameByRawQuery2(@RequestParam("MedicineNames") String Med) {
        List<String> MedicineName = Arrays.asList(Med.split(" "));
        List<SearchMedicine> Final=supplierMedicineService.getSupplierNameByRawQuery2(MedicineName);
       // System.out.println(MedicineName.get(2));

//                Final.add(supplierMedicineService.getSupplierNameByRawQuery2(MedicineName));
        //System.out.println(Final);
        return new ResponseEntity<>(Final,HttpStatus.OK);

    }
}

