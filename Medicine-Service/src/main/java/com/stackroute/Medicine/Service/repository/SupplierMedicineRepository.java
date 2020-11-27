package com.stackroute.Medicine.Service.repository;

import com.stackroute.Medicine.Service.domain.SupplierMedicine;
import com.stackroute.Medicine.Service.domain.SupplierMedicineId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierMedicineRepository extends CrudRepository<SupplierMedicine, Integer>  {

}
