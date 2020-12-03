package com.stackroute.Medicine.Service.repository;

import com.stackroute.Medicine.Service.domain.CompositeKey;
import com.stackroute.Medicine.Service.domain.SearchMedicine;
import com.stackroute.Medicine.Service.domain.SupplierMedicine;
//import com.stackroute.Medicine.Service.domain.SupplierMedicineId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierMedicineRepository extends CrudRepository<SupplierMedicine, CompositeKey>  {
    String rawQuery = "select * from supplier_medicine where supplier_name=?1";
    @Query(nativeQuery = true,value = rawQuery)
    List<SupplierMedicine> findBySupplierName (String SupplierName);

    String rawQuery1 = "SELECT * FROM supplier_medicine WHERE medicine_name=?1";
    @Query(nativeQuery = true,value = rawQuery1)
    List<SupplierMedicine> findByMedicineName (String medicineName);
}
