package com.stackroute.Medicine.Service.controller;


import com.stackroute.Medicine.Service.domain.SupplierMedicine;
import com.stackroute.Medicine.Service.service.SupplierMedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    /* Provide implementation code for these methods */

    /*This method should save blog and return savedBlog Object */
    @PostMapping("/blogr")
    public ResponseEntity<SupplierMedicine> saveSupplierMedicine(@RequestBody SupplierMedicine supplierMedicine) {
        return new ResponseEntity<>(supplierMedicineService.saveSupplierMedicine(supplierMedicine), HttpStatus.CREATED);
    }

    /*This method should fetch all blogs and return the list of all blogs */
    @GetMapping("/blogss")
    public ResponseEntity<List<SupplierMedicine>> getAllSupplierMedicines() {
        return new ResponseEntity<List<SupplierMedicine>>((List<SupplierMedicine>) supplierMedicineService.getAllSupplierMedicines(),HttpStatus.FOUND);
    }

    /*This method should fetch the blog taking its id and return the respective blog */
    @GetMapping("/blogs/{id}")
    public ResponseEntity<SupplierMedicine> getSupplierMededicineById(@PathVariable int id){
        return new ResponseEntity<SupplierMedicine>(supplierMedicineService.getSupplierById(id), HttpStatus.FOUND
        );
    }

    /*This method should delete the blog taking its id and return the deleted blog */
    @DeleteMapping("/blogs/{id}")
    public ResponseEntity<SupplierMedicine> getSupplierMedicineAfterDeleting(@PathVariable int id) {
        return new ResponseEntity<SupplierMedicine>(supplierMedicineService.deleteSupplierMedicine(id),HttpStatus.OK);
    }

    /*This method should update blog and return the updatedBlog */
    @PutMapping("/blogsss")
    public ResponseEntity<?> updateSupplierMedicine(@RequestBody SupplierMedicine supplierMedicine) {
        return new ResponseEntity<>(supplierMedicineService.updateSupplier(supplierMedicine),HttpStatus.OK);
    }
}
