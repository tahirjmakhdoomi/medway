import { HttpErrorResponse, HttpEventType } from '@angular/common/http';
import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { MatDialog, MatDialogModule, MatDialogRef } from '@angular/material';
import { ActivatedRoute } from '@angular/router';
import { forkJoin, of } from 'rxjs';
import { catchError, map } from 'rxjs/operators';
import { DialogComponent } from '../dialog/dialog.component';
import { AddPrescriptionService } from '../services/add-prescription.service';
import { NavigationService } from '../services/navigation.service';

@Component({
  selector: 'app-add-prescription',
  templateUrl: './add-prescription.component.html',
  styleUrls: ['./add-prescription.component.css']
})
export class AddPrescriptionComponent implements OnInit {
  medicines : any[] = [];
  username : String;

  constructor(private dialog: MatDialog, public uploadService: AddPrescriptionService,private route : ActivatedRoute,
              private navigate : NavigationService) { }
  ngOnInit(): void{
    // this.username = this.route.snapshot.paramMap.get('username');
    this.username = this.route.snapshot.queryParams.username;
    console.log("this is ",this.username);
    this.uploadService.username = this.username;
  }

  public openUploadDialog() {
    let dialogRef = this.dialog.open(DialogComponent, { width: '70%', height: '40%' });
    this.medicines = this.uploadService.medicines;
    console.log(this.medicines);
  }

  medicineList(){
    this.navigate.medicinelist();
  }

}
