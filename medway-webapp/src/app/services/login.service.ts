import { Injectable } from '@angular/core';

import { Observable, throwError } from 'rxjs';
import { retry, catchError, map } from 'rxjs/operators';

import { HttpClient, HttpErrorResponse} from '@angular/common/http';
import { LoginModel } from '../models/loginModel';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http:HttpClient) {

   }
   postUserData(val:LoginModel){
     return this.http.post('http://localhost:8080/auth-service/api/v1/validate',val,{responseType : 'text' as 'json',withCredentials: true});
   }
}
