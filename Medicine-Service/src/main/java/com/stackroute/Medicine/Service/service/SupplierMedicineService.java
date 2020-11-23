package com.stackroute.Medicine.Service.service;


import com.stackroute.Medicine.Service.domain.SupplierMedicine;

import java.util.List;

public interface SupplierMedicineService {
    /**
     * AbstractMethod to save a blog
     */
    SupplierMedicine saveSupplierMedicine (SupplierMedicine suppliermedicine);

    /**
     * AbstractMethod to get all blogs
     */
    List<SupplierMedicine> getAllSupplierMedicines();

    /**
     * AbstractMethod to get blog by id
     */
    SupplierMedicine getSupplierById(int id);

    /**
     * AbstractMethod to delete blog by id
     */
    SupplierMedicine deleteSupplierMedicine(int id);

    /**
     * AbstractMethod to update a blog
     */
    SupplierMedicine updateSupplier(SupplierMedicine suppliermedicine);
}
