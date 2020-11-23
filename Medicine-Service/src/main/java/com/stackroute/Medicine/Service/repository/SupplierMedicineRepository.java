package com.stackroute.Medicine.Service.repository;

import com.stackroute.Medicine.Service.domain.SupplierMedicine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierMedicineRepository extends CrudRepository<SupplierMedicine,Integer>  {

}
