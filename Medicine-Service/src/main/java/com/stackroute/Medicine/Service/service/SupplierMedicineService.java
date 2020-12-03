package com.stackroute.Medicine.Service.service;


import com.stackroute.Medicine.Service.domain.SearchMedicine;
import com.stackroute.Medicine.Service.domain.SupplierMedicine;

import java.util.List;

public interface SupplierMedicineService {

    SupplierMedicine saveSupplierMedicine (SupplierMedicine suppliermedicine);

   List<SupplierMedicine> getSupplierNameByRawQuery1(String supplierName);

    List<SearchMedicine> getSupplierNameByRawQuery2(List<String> MedicineName);

}
