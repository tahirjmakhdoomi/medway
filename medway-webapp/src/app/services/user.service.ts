import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { retry, catchError } from 'rxjs/operators';
import { endPoints } from 'src/environments/environment';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { UserModel } from '../models/userModel';

@Injectable({
  providedIn: 'root'
})

export class UserService {

  url = 'http://localhost:8080/UserService/api/v1/register';

  constructor(private _http: HttpClient) { }

  getAllUsers() {
    return this._http.get<UserModel[]>('http://localhost:8080/UserService/api/v1/users').pipe(
      retry(3),
      catchError(this.handleError)
    );
  }

  addUser(item: UserModel) {
    return this._http.post(this.url, item, { responseType: 'text' as 'json' }).pipe(catchError(this.handleError));
  }

  private handleError(ex: HttpErrorResponse) {
    if (ex.error instanceof ErrorEvent) {
      console.log('Client side error', ex.message);
    } else {
      console.log('Server side error', ex.message);
    }
    return throwError('Something went wrong!');
  }

  //   getUser(){
  //     return this._http.get("https://localhost:8888/google/login",{responseType : 'text' as 'json'});
  //   }

  getOrderSummary(name: String): Observable<UserModel> {
    return this._http.get<UserModel>("http://localhost:8080/UserService/api/v1/orders/" + name);
  }
}
