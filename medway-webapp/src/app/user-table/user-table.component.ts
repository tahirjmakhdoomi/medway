import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormArray, Validators } from '@angular/forms';

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
  constructor(private fb: FormBuilder) { }

  ngOnInit(): void {
    this.touchedRows = [];
    this.userTable = this.fb.group({
      tableRows: this.fb.array([])
    });
    this.addRow();
  }

  ngAfterOnInit() {
    this.control = this.userTable.get('tableRows') as FormArray;
  }
  message = '';
  initiateForm(): FormGroup {
    return this.fb.group({
      medicineName: ['', Validators.required],
      expiryDOB: ['', [ Validators.required]],
      quantity: ['', [Validators.required]],
      discount: [''],
      price: ['', [Validators.required, Validators.maxLength(10)]],
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
    console.log(this.touchedRows);
    if(this.userTable.status==="INVALID"){
      this.message="Please verify entered details!!!";
    }
    // else if(this.userTable.status==="VALID"){
    //   this.medicineService.addMedicine(this.userTable.value).subscribe(()=>{this.message="Medicine added";}, 
    //   ()=>{this.message="Failed to add Medicine!!";});
    // }
    this.clearForm();
  }  
  clearForm(){
    const control =  this.userTable.get('tableRows') as FormArray;
    control.reset();
    control.push(this.initiateForm());
  }
  toggleTheme() {
    this.mode = !this.mode;
  }
}
