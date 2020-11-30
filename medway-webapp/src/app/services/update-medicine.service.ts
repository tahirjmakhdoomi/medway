import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Medicine } from '../models/medicine';

@Injectable({
  providedIn: 'root'
})
export class UpdateMedicineService {

  username;

  constructor(private httpclient: HttpClient) {}
  addMedicine(medicine : Medicine) : Observable<Medicine> {
    return this.httpclient.post<Medicine>("http://localhost:8105/api/v1/blogr", medicine);
  }
  getAllMedicine(supplierName : String ) : Observable<any> {
    return this.httpclient.get<any>("http://localhost:8105/api/v1/getMedicine/"+supplierName);
  }
  updateMedicine(medicine : Medicine) : Observable<Medicine> {
    return this.httpclient.post<Medicine>("http://localhost:8105/api/v1/updateMedicine", medicine);
  }
}
