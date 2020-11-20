import { Injectable } from '@angular/core';
import { throwError } from 'rxjs';
import { retry, catchError } from 'rxjs/operators';
import { endPoints } from 'src/environments/environment';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { UserModel } from '../models/userModel';

@Injectable({
  providedIn: 'root'
})

export class UserService {

  url = 'http://localhost:8100/api/v1/register';

  constructor(private _http: HttpClient) {}

  getAllUsers() {
    return this._http.get<UserModel[]>('http://localhost:8100/api/v1/users').pipe(
      retry(3),
      catchError(this.handleError)
    );
  }

  addUser(item: UserModel) {
    return this._http.post(this.url, item, {responseType:'text' as 'json'}).pipe(catchError(this.handleError));
  }

  private handleError(ex: HttpErrorResponse) {
    if (ex.error instanceof ErrorEvent) {
      console.log('Client side error', ex.message);
    } else {
      console.log('Server side error', ex.message);
    }
    return throwError('Something went wrong!');
  }

  getUser(){
    return this._http.get("http://localhost:8100/api/v1/facebook",{responseType : 'text' as 'json'});
  }
}
