package com.stackroute.Medicine.Service.searchApi;

import com.stackroute.Medicine.Service.domain.SearchMedicine;
import com.stackroute.Medicine.Service.domain.SupplierMedicine;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class SearchService {

    public SearchMedicine finalResult(List<SupplierMedicine> medicineDB){
        SearchMedicine obj = new SearchMedicine();
        SearchMedicine result = new SearchMedicine();
        float min = Integer.MAX_VALUE;
        for(int i=0;i<medicineDB.size();i++) {
            float discount = medicineDB.get(i).getDiscount();
            float price = medicineDB.get(i).getPrice();
            float finalPrice = price - (price * discount) / 100;


            obj.setMedicineName(medicineDB.get(i).getMedicineName());
            obj.setManufactureDate(medicineDB.get(i).getManufactureDate());
            obj.setExpDate(medicineDB.get(i).getExpDate());
            obj.setDiscount(discount);
            obj.setPrice(price);
            obj.setFinalPrice(finalPrice);
            if (min > finalPrice) {
                min = finalPrice;
                result = obj;
            }
        }
        return result;
    }
}
