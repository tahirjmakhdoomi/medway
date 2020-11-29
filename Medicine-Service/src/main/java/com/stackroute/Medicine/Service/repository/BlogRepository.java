package com.stackroute.Medicine.Service.repository;

import com.stackroute.Medicine.Service.domain.Supplier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends CrudRepository<Supplier,Integer>  {
    String rawQuery = "select supplier_id from supplier where supplier_name=?1";
    @Query(nativeQuery = true,value = rawQuery)
    int findBySupplierName (String SupplierName);

}
