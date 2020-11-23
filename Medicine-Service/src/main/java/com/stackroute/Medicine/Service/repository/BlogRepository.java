package com.stackroute.Medicine.Service.repository;

import com.stackroute.Medicine.Service.domain.Supplier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends CrudRepository<Supplier,Integer>  {

}
