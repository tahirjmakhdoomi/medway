package com.stackroute.Medicine.Service.service;

//import com.stackroute.domain.SupplierMedicine;
//import com.stackroute.repository.SupplierMedicineRepository;
import com.stackroute.Medicine.Service.domain.CompositeKey;
import com.stackroute.Medicine.Service.domain.SearchMedicine;
import com.stackroute.Medicine.Service.domain.SupplierMedicine;
import com.stackroute.Medicine.Service.repository.SupplierMedicineRepository;
//import com.stackroute.Medicine.Service.searchApi.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/* Add annotation to declare this class as Service class.
 * Also it should implement BlogService Interface and override all the implemented methods.*/
@Service
public class SupplierMedicineServiceImpl implements SupplierMedicineService{

    private SupplierMedicineRepository supplierMedicineRepository;
//    private SearchService searchService;

    @Autowired
    public SupplierMedicineServiceImpl(SupplierMedicineRepository supplierMedicineRepository ) {
        this.supplierMedicineRepository = supplierMedicineRepository;
//        this.searchService = searchService;

    }

    @Override
    public SupplierMedicine saveSupplierMedicine(SupplierMedicine supplierMedicine) {
        return supplierMedicineRepository.save(supplierMedicine);
    }

//    @Override
//    public List<SupplierMedicine> getAllSupplierMedicines() {
//        return (List<SupplierMedicine>) supplierMedicineRepository.findAll();
//    }

//
//    @Override
//    public SupplierMedicine getSupplierById(int id) {
////        return blogRepository.findById(id).get();
//        Optional<SupplierMedicine> blogDb=this.supplierMedicineRepository.findById(id);
//        if(blogDb.isPresent()){
//            return blogDb.get();
//        }
//        else
//            return null;
//    }

//    @Override
//    public SupplierMedicine deleteSupplierMedicine(int id) {
//        Optional<SupplierMedicine> blogDb=this.supplierMedicineRepository.findById(id);
//        if(blogDb.isPresent()){
//            SupplierMedicine supplier =blogDb.get();
//            this.supplierMedicineRepository.delete(blogDb.get());
//            return supplier;

//        else
//            return null;
//    }

//    @Override
//    public List<SearchMedicine> allSearchMedicine(List<String> medicineName) {
//        List<SearchMedicine> result = new ArrayList<>();
//        for(int i=0;i<medicineName.size();i++){
//            result.add(this.searchService.finalResult(getAllMedicineById(medicineName.get(i))));
//        }
//        return result;
//    }

//    @Override
//    public List<SupplierMedicine> getAllMedicineById(int id) {
//        return (List<SupplierMedicine>) supplierMedicineRepository.findAll();
//    }

//    @Override
//    public SupplierMedicine updateSupplier(SupplierMedicine supplierMedicine) {
//
//        Optional<SupplierMedicine> blogDb=this.supplierMedicineRepository.findById(supplierMedicine.getCompositeKey());
//        if(blogDb.isPresent()){
//            SupplierMedicine supplierUpdated =blogDb.get();
//            supplierUpdated.setCompositeKey  (supplierMedicine.getCompositeKey());
//            supplierUpdated.setPrice(supplierMedicine.getPrice());
//            supplierUpdated.setDiscount(supplierMedicine.getDiscount());
//            supplierUpdated.setStock(supplierMedicine.getStock());
//            supplierUpdated.setManufactureDate(supplierMedicine.getManufactureDate());
//            supplierUpdated.setExpDate(supplierMedicine.getExpDate());
//
//            this.supplierMedicineRepository.save(supplierUpdated);
//            return supplierUpdated;
//        }
//        else
//            return null;
//    }

    public List<SupplierMedicine> getSupplierNameByRawQuery1(String SupplierName)
    {

        List<SupplierMedicine> K=supplierMedicineRepository.findBySupplierName(SupplierName);
        return K;
    }

    public List<SearchMedicine> getSupplierNameByRawQuery2(List<String> MedicineName) {
        List<SearchMedicine> result = new ArrayList<>();
//        System.out.println(MedicineName);
        for (int i = 0; i < MedicineName.size(); i++) {
            List<SupplierMedicine> dummy = new ArrayList<>();
            dummy.addAll(supplierMedicineRepository.findByMedicineName(MedicineName.get(i)));

            SearchMedicine x = new SearchMedicine();
             x.setMedicineName(MedicineName.get(i));
            for (int j = 0; j < dummy.size(); j++) {
              //  System.out.println(dummy.size());
                x.setSupplierName(dummy.get(j).getCompositeKey().getSupplierName());
                x.setManufactureDate(dummy.get(j).getManufactureDate());
                x.setExpDate(dummy.get(j).getExpDate());
                x.setStock(dummy.get(j).getStock());
                x.setDiscount(dummy.get(j).getDiscount());
                x.setPrice(dummy.get(j).getPrice());
                result.add(x);
            }
        }
        return result;
    }
}
