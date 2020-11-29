package com.stackroute.Medicine.Service.repository;

import com.stackroute.Medicine.Service.domain.SupplierMedicine;
//import com.stackroute.Medicine.Service.domain.SupplierMedicineId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierMedicineRepository extends CrudRepository<SupplierMedicine, Integer>  {
    String rawQuery = "select * from supplier_medicine where supplier_id=?1";
    @Query(nativeQuery = true,value = rawQuery)
    List<SupplierMedicine> findBySupplierId (int SupplierId);
}
