import { HttpClient, HttpEventType, HttpRequest, HttpResponse } from '@angular/common/http';
import { Injectable, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable, Subject } from 'rxjs';
import { LoginComponent } from '../login/login.component';
import { UserService } from './user.service';

@Injectable({
  providedIn: 'root'
})
export class AddPrescriptionService implements OnInit{
  medicines : any[] = [];
  s : String[];

  url = 'http://localhost:8071/api/v1/upload';

  constructor(private http: HttpClient) { }
  ngOnInit(): void {
  }

  

  public upload(
    files: Set<File>,userName : any
  ): { [key: string]: { progress: Observable<any> } } {
    // this will be the our resulting map
    const status: { [key: string]: { progress: Observable<any> } } = {};

    files.forEach(file => {
      // create a new multipart-form for every file
      const formData: FormData = new FormData();
      formData.append('file', file, file.name);
      formData.append('username',userName);
      formData.append('prescriptionId','1234');
      console.log(formData);
      console.log(userName);

      // create a http-post request and pass the form
      // tell it to report the upload progress
      const req = new HttpRequest('POST', this.url, formData, {
        reportProgress: true,
        responseType: 'text' as 'json'
      });

      // create a new progress-subject for every file
      const progress = new Subject<any>();

      // send the http-request and subscribe for progress-updates
      this.http.request(req).subscribe(event => {
        if (event.type === HttpEventType.UploadProgress) {
          // calculate the progress percentage
           
          const percentDone = Math.round((100 * event.loaded) / event.total);
          // pass the percentage into the progress-stream
          progress.next(percentDone);
        } else if (event instanceof HttpResponse) {
          // Close the progress-stream if we get an answer form the API
          // The upload is complete
          progress.next(event.body);
          // this.s=<String[]>event.body;
          // console.log(this.s[2]);
          // for(let i=0;i<this.s.length;i++){
          //   this.s[i].split("\"");
          //   <String[]>event.body;
          // }
          this.medicines.push(<String[]>event.body);
          console.log(this.medicines);
          progress.complete();
        }
      });

      // Save every progress-observable in a map of all observables
      status[file.name] = {
        progress: progress.asObservable()
      };
    });

    // return the map of progress.observables
    return status;
  }


}
