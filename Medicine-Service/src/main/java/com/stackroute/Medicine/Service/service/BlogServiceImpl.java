package com.stackroute.Medicine.Service.service;

//import com.stackroute.domain.Supplier;
//import com.stackroute.repository.BlogRepository;
import com.stackroute.Medicine.Service.domain.Supplier;
import com.stackroute.Medicine.Service.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/* Add annotation to declare this class as Service class.
 * Also it should implement BlogService Interface and override all the implemented methods.*/
@Service
public class BlogServiceImpl implements BlogService{

    private BlogRepository blogRepository;

    @Autowired
    public BlogServiceImpl(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Override
    public Supplier saveSupplier(Supplier supplier) {
        return blogRepository.save(supplier);
    }

    @Override
    public List<Supplier> getAllSuppliers() {
        return (List<Supplier>) blogRepository.findAll();
    }

    @Override
    public Supplier getSupplierById(int id) {
//        return blogRepository.findById(id).get();
        Optional<Supplier> blogDb=this.blogRepository.findById(id);
        if(blogDb.isPresent()){
            return blogDb.get();
        }
        else
            return null;
    }

    @Override
    public Supplier deleteSupplier(int id) {
        Optional<Supplier> blogDb=this.blogRepository.findById(id);
        if(blogDb.isPresent()){
            Supplier supplier =blogDb.get();
            this.blogRepository.delete(blogDb.get());
            return supplier;
        }
        else
            return null;
    }

    @Override
    public Supplier updateSupplier(Supplier supplier) {
        Optional<Supplier> blogDb=this.blogRepository.findById(supplier.getSupplierId());
        if(blogDb.isPresent()){
            Supplier supplierUpdated =blogDb.get();
            supplierUpdated.setSupplierId(supplier.getSupplierId());
            supplierUpdated.setSupplierName(supplier.getSupplierName());
            supplierUpdated.setLicenseNumber(supplier.getLicenseNumber());

            this.blogRepository.save(supplierUpdated);
            return supplierUpdated;
        }
        else
            return null;
    }
}
