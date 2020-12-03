import { Component, OnInit } from '@angular/core';
import { FormGroup, FormArray, FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Medicine } from '../models/medicine';
import { AddPrescriptionService } from '../services/add-prescription.service';
import { UpdateMedicineService } from '../services/update-medicine.service';
import Swal from 'sweetalert2/dist/sweetalert2.js'

@Component({
  selector: 'app-update-medicine',
  templateUrl: './update-medicine.component.html',
  styleUrls: ['./update-medicine.component.css']
})
export class UpdateMedicineComponent implements OnInit {
  userTable: FormGroup;
  control: FormArray;
  mode: boolean;
  touchedRows: any;
  username:string;
  medicine : Medicine;
  medicines : Medicine[];
  searchText :string;
  // {medicineName : "dolo", manufactureDate :new Date("2002-11-11"), expDate :new Date("2022-11-11"),stock : 10, discount :20, price : 20, supplierName : "rajesh1"}
  material = [];
  constructor(private fb: FormBuilder, private updateMedicineService : UpdateMedicineService) { }
    
  ngOnInit(): void {
    this.touchedRows = []; 
    // console.log(this.material);
    this.userTable = this.fb.group({
      tableRows: this.fb.array([])
    });
    this.username = this.updateMedicineService.username;
    const control =  this.userTable.get('tableRows') as FormArray;
    // this.addRow();
  }

  ngAfterOnInit() {
    this.control = this.userTable.get('tableRows') as FormArray;
  }
  search(){
    this.clearForm();
    if(this.searchText){
      this.updateMedicineService.getAllMedicine(this.username).subscribe(data => {
        // console.log(data);
        // this.medicines = Object.assign([],data);
        // console.log(this.medicines);
        // data.forEach(element => {
        //   control.push(this.initiateForm(element.medicineName,element.manufactureDate,element.expDate,element.stock,element.discount,element.price));
        // });
        const control =  this.userTable.get('tableRows') as FormArray;
      this.material = data.filter(x=>x.compositeKey.medicineName.toLowerCase().includes(this.searchText.toLowerCase()));
      //console.log(this.material);
      this.material.forEach(element =>{ 
       // console.log(element);
        control.push(this.initiateForm(element.compositeKey.medicineName,element.manufactureDate, element.expDate, element.stock, element.discount, element.price))
      });
      });
 
      
    }
  }
  
  message = '';
  initiateForm(medicineName : string, manufactureDate : Date, expDate : Date, stock : number, discount : number, price : number): FormGroup {
    return this.fb.group({
      compositeKey : this.fb.group
      ({medicineName: [medicineName, Validators.required],
      supplierName:[this.username]}),
      manufacturingDate: [manufactureDate, Validators.required],
      expDate: [expDate, [ Validators.required]],
      stock: [stock, [Validators.required]],
      discount: [discount,[Validators.required, Validators.pattern(/^[.\d]+$/)]],
      price: [price, [Validators.required, Validators.pattern(/^[.\d]+$/)]],
      isEditable: [false]
    });
  }

  // addRow() {
  //   const control =  this.userTable.get('tableRows') as FormArray;
  //   control.push(this.initiateForm());
  // }

  // deleteRow(index: number) {
  //   const control =  this.userTable.get('tableRows') as FormArray;
    
  //   if(control.length == 1){
  //     control.push(this.initiateForm());
  //   }
  //   control.removeAt(index);
  // }

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
    //console.log(this.touchedRows);
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
        // console.log("abs");
        // console.log(element.value.compositKey.medicineName);
        // console.log(control.controls);
        // console.log(medicineValues);
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
  //  control.push(this.initiateForm()); 
  }
}