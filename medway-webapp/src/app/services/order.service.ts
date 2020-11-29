import { Injectable } from '@angular/core';
import { throwError } from 'rxjs';
import { retry, catchError } from 'rxjs/operators';
import { endPoints } from 'src/environments/environment';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { orderModel } from '../models/orderModel';


@Injectable({
  providedIn: 'root'
})

export class orderService {

  url = 'http://localhost:8110/api/v1/entry';

  constructor(private _http: HttpClient) {}



  addUser(item: orderModel) {
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


}
