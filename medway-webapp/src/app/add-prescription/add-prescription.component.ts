import { HttpErrorResponse, HttpEventType } from '@angular/common/http';
import { Component, ElementRef, OnChanges, OnInit, SimpleChanges, ViewChild } from '@angular/core';
import { MatDialog, MatDialogModule, MatDialogRef } from '@angular/material';
import { ActivatedRoute } from '@angular/router';
import { forkJoin, of } from 'rxjs';
import { catchError, map } from 'rxjs/operators';
import { DialogComponent } from '../dialog/dialog.component';
import { medicineList } from '../models/medicine-list';
import { Prescription } from '../models/prescription';
import { AddPrescriptionService } from '../services/add-prescription.service';
import { commonService } from '../services/common.service';
import { NavigationService } from '../services/navigation.service';

@Component({
  selector: 'app-add-prescription',
  templateUrl: './add-prescription.component.html',
  styleUrls: ['./add-prescription.component.css']
})
export class AddPrescriptionComponent implements OnInit {
  medicines : medicineList[] = [];
  username : String;
  prescriptions : Prescription[];
  detectedMedicines: any[];

  constructor(private common:commonService,private dialog: MatDialog, public uploadService: AddPrescriptionService,private route : ActivatedRoute,
              private navigate : NavigationService) { }
  ngOnInit(): void{
    // this.username = this.route.snapshot.paramMap.get('username');
    this.username = this.route.snapshot.queryParams.username;
    console.log("this is ",this.username);
    this.uploadService.username = this.username;
    this.uploadService.getPrescriptions(this.username).subscribe(data => {
      this.prescriptions = data;
      console.log(this.prescriptions);
    })
  }

  

  public openUploadDialog() {
    let dialogRef = this.dialog.open(DialogComponent, { width: '70%', height: '40%' });
    this.medicines = this.uploadService.medicines;
  }

  medicineList(index){
    this.detectedMedicines = this.prescriptions[index-1].detectedMedicines;
    console.log(this.detectedMedicines.join(" "));
    this.uploadService.getDetails(this.detectedMedicines.join(" ")).subscribe(
      data => {
        this.uploadService.medicines = data;
        console.log(this.uploadService.medicines);
        this.navigate.medicinelist();
      }
    );
  }

}
