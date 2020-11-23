import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Medicine } from '../models/medicine';

@Injectable({
  providedIn: 'root'
})
export class UpdateMedicineService {

  constructor(private httpclient: HttpClient) {}
  addMedicine(medicine : Medicine) : Observable<Medicine> {
    return this.httpclient.post<Medicine>("http://localhost:8105/api/v1/blogr", medicine);
  }
}
