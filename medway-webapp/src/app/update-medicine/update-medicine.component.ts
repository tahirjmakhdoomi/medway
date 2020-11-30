import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Medicine } from '../models/medicine';
import { SupplierMedicine } from '../models/supplier-medicine';
import { AddPrescriptionService } from '../services/add-prescription.service';
import { UpdateMedicineService } from '../services/update-medicine.service';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-update-medicine',
  templateUrl: './update-medicine.component.html',
  styleUrls: ['./update-medicine.component.css']
})
export class UpdateMedicineComponent implements OnInit {
  medicines : SupplierMedicine[] = [];
  message;
  flag = true;
  form: any = {};
  username:String;
constructor(private updateMedicineService : UpdateMedicineService, private route : AddPrescriptionService) {}
// Call UserService and use getAllContacts method to get Contacts data
  ngOnInit() {

    this.username = this.route.username;
    const supplierName = this.username;
    this.updateMedicineService.getAllMedicine(supplierName).subscribe(
      data => {
        this.medicines = data;
      });
  }

  // Write logic to add a Contact by using addContact method of UserService
  // Display message 'Contact already exists' if already a contact exists with same mobile number
  // Display message 'Failed to add Contact' while error handling
  // Display message 'Contact Added' if contact is added
   editRow(){
      this.flag = true;
   }
  onSubmit() {
    this.flag = false;
      this.medicines.forEach(element => {
        const medicineValues : Medicine = new Medicine(
          element.medicineName,
          element.manufactureDate,
          element.expDate,
          element.stock,
          element.discount,
          element.price,
          this.route.username
        );
        this.updateMedicineService.updateMedicine(medicineValues).subscribe(()=>{this.message="Medicine added";}, 
      ()=>{this.message="Failed to add Medicine!!";});
      });
    }

}
