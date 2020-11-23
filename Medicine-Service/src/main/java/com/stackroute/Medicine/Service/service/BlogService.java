package com.stackroute.Medicine.Service.service;


import com.stackroute.Medicine.Service.domain.Supplier;

import java.util.List;

public interface BlogService {
    /**
     * AbstractMethod to save a blog
     */
    Supplier saveSupplier(Supplier supplier);

    /**
     * AbstractMethod to get all blogs
     */
    List<Supplier> getAllSuppliers();

    /**
     * AbstractMethod to get blog by id
     */
    Supplier getSupplierById(int id);

    /**
     * AbstractMethod to delete blog by id
     */
    Supplier deleteSupplier(int id);

    /**
     * AbstractMethod to update a blog
     */
    Supplier updateSupplier(Supplier supplier);
}