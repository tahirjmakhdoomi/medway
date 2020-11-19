import { Injectable } from '@angular/core';

import { Observable, throwError } from 'rxjs';
import { retry, catchError } from 'rxjs/operators';

import { HttpClient, HttpErrorResponse} from '@angular/common/http';
import { LoginModel } from '../models/loginModel';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  
  constructor(private http:HttpClient) {
    
   }
   postUserData(val:LoginModel):Observable<any>{
     return this.http.post('http://localhost:4202/users',val)
   }
}
