import { HttpErrorResponse, HttpEventType } from '@angular/common/http';
import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { MatDialog, MatDialogModule, MatDialogRef } from '@angular/material';
import { forkJoin, of } from 'rxjs';
import { catchError, map } from 'rxjs/operators';
import { DialogComponent } from '../dialog/dialog.component';
import { AddPrescriptionService } from '../services/add-prescription.service';

@Component({
  selector: 'app-add-prescription',
  templateUrl: './add-prescription.component.html',
  styleUrls: ['./add-prescription.component.css']
})
export class AddPrescriptionComponent implements OnInit {
  medicines : any[] = [];
  constructor(private dialog: MatDialog, public uploadService: AddPrescriptionService) { }
  ngOnInit(){
  }

  public openUploadDialog() {
    let dialogRef = this.dialog.open(DialogComponent, { width: '70%', height: '40%' });
    this.medicines = this.uploadService.medicines;
    console.log(this.medicines);
  }


}
