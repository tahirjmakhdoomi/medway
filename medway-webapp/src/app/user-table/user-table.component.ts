import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormArray, Validators } from '@angular/forms';
import { ActivatedRoute, ActivatedRouteSnapshot } from '@angular/router';
import { Medicine } from '../models/medicine';
import { UpdateMedicineService } from '../services/update-medicine.service';
import Swal from 'sweetalert2/dist/sweetalert2.js'

@Component({
  selector: 'app-user-table',
  templateUrl: './user-table.component.html',
  styleUrls: ['./user-table.component.scss']
})
export class UserTableComponent implements OnInit {
  userTable: FormGroup;
  control: FormArray;
  mode: boolean;
  touchedRows: any;
  username: string;
  // material1 : Medicine[];
  // material = [{medicineName : "dolo", manufactureDate : "2002-11-11", expDate : "2022-11-11",stock : 10, discount :20, price : 20, supplierName : "rajesh1"}];
  constructor(private fb: FormBuilder, private updateMedicineService : UpdateMedicineService, private route : ActivatedRoute) { }
  
  ngOnInit(): void {
    this.touchedRows = [];
    // console.log(this.material1);
    this.userTable = this.fb.group({
      tableRows: this.fb.array([])
    });
    this.addRow();
    this.username = this.route.snapshot.queryParams.username;
    this.updateMedicineService.username = this.username;
    console.log(this.username);
  }

  ngAfterOnInit() {
    this.control = this.userTable.get('tableRows') as FormArray;
  }
  
  message = '';
  initiateForm(): FormGroup {
    return this.fb.group({
      compositeKey : this.fb.group
      ({medicineName: ['', Validators.required],
      supplierName:[this.route.snapshot.queryParams.username]}),
      manufacturingDate: ['', Validators.required],
      expDate: ['', [ Validators.required]],
      stock: ['', [Validators.required]],
      discount: ['',[Validators.required, Validators.pattern(/^[.\d]+$/)]],
      price: ['', [Validators.required, Validators.pattern(/^[.\d]+$/)]],
      isEditable: [true]
    });
  }

  addRow() {
    const control =  this.userTable.get('tableRows') as FormArray;
    control.push(this.initiateForm());
  }

  deleteRow(index: number) {
    const control =  this.userTable.get('tableRows') as FormArray;
    
    if(control.length == 1){
      control.push(this.initiateForm());
    }
    control.removeAt(index);
  }

  editRow(group: FormGroup) {
    group.get('isEditable').setValue(true);
  }

  doneRow(group: FormGroup) {
    group.get('isEditable').setValue(false);
  }

  saveUserDetails() {
    console.log(this.userTable.value);
  }

  get getFormControls() {
    const control = this.userTable.get('tableRows') as FormArray;
    return control;
  }

  submitForm() {
    
    const control = this.userTable.get('tableRows') as FormArray;
    this.touchedRows = control.controls.filter(row => row.touched).map(row => row.value);
    // console.log(this.touchedRows);
    if(this.userTable.status==="INVALID"){
      this.message="Please verify entered details!!!";
    }
    else if(this.userTable.status==="VALID"){
     
      control.controls.forEach(element => {
        const medicineValues : Medicine = new Medicine(
          element.get("compositeKey").value,
          element.get("manufacturingDate").value,
          element.get("expDate").value,
          element.get("stock").value,
          element.get("discount").value,
          element.get("price").value
          // "rajesh1"
        );
        // console.log(element.get("compositekey").value);
        console.log(control.controls);
        console.log("abs");
        // console.log(element.value.compositKey.medicineName);
        console.log(medicineValues);
        this.updateMedicineService.addMedicine(medicineValues).subscribe(()=>{
          Swal.fire({
            icon: 'success',
            title: 'Success',
            text: 'Medicine successfully uploaded'});
          }, 
      (error)=>{
        Swal.fire({
          icon: 'error',
          title: 'oops',
          text: 'Medicine not updated'});
        })
      });
    }
    this.clearForm();
  }  
  clearForm(){
    const control =  this.userTable.get('tableRows') as FormArray;
    while(control.length >0){
      control.removeAt(0);
    }
    control.push(this.initiateForm());
  }
  toggleTheme() {
    this.mode = !this.mode;
  }
}