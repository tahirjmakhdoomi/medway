package com.stackroute.Medicine.Service.service;

//import com.stackroute.domain.SupplierMedicine;
//import com.stackroute.repository.SupplierMedicineRepository;
import com.stackroute.Medicine.Service.domain.SupplierMedicine;
import com.stackroute.Medicine.Service.repository.SupplierMedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/* Add annotation to declare this class as Service class.
 * Also it should implement BlogService Interface and override all the implemented methods.*/
@Service
public class SupplierMedicineServiceImpl implements SupplierMedicineService{

    private SupplierMedicineRepository supplierMedicineRepository;

    @Autowired
    public SupplierMedicineServiceImpl(SupplierMedicineRepository supplierMedicineRepository) {
        this.supplierMedicineRepository = supplierMedicineRepository;
    }

    @Override
    public SupplierMedicine saveSupplierMedicine(SupplierMedicine supplierMedicine) {
        return supplierMedicineRepository.save(supplierMedicine);
    }

    @Override
    public List<SupplierMedicine> getAllSupplierMedicines() {
        return (List<SupplierMedicine>) supplierMedicineRepository.findAll();
    }

    @Override
    public SupplierMedicine getSupplierById(int id) {
//        return blogRepository.findById(id).get();
        Optional<SupplierMedicine> blogDb=this.supplierMedicineRepository.findById(id);
        if(blogDb.isPresent()){
            return blogDb.get();
        }
        else
            return null;
    }

    @Override
    public SupplierMedicine deleteSupplierMedicine(int id) {
        Optional<SupplierMedicine> blogDb=this.supplierMedicineRepository.findById(id);
        if(blogDb.isPresent()){
            SupplierMedicine supplier =blogDb.get();
            this.supplierMedicineRepository.delete(blogDb.get());
            return supplier;
        }
        else
            return null;
    }

    @Override
    public SupplierMedicine updateSupplier(SupplierMedicine supplierMedicine) {
        Optional<SupplierMedicine> blogDb=this.supplierMedicineRepository.findById(supplierMedicine.getSupplierId());
        if(blogDb.isPresent()){
            SupplierMedicine supplierUpdated =blogDb.get();
            supplierUpdated.setSupplierId(supplierMedicine.getSupplierId());
            supplierUpdated.setMedicineId(supplierMedicine.getMedicineId());
            supplierUpdated.setPrice(supplierMedicine.getPrice());
            supplierUpdated.setDiscount(supplierMedicine.getDiscount());
            supplierUpdated.setStock(supplierMedicine.getStock());
            supplierUpdated.setManufactureDate(supplierMedicine.getManufactureDate());
            supplierUpdated.setExpDate(supplierMedicine.getExpDate());

            this.supplierMedicineRepository.save(supplierUpdated);
            return supplierUpdated;
        }
        else
            return null;
    }
}
