import { Component, OnInit, APP_INITIALIZER } from '@angular/core';
import { medicineList } from '../models/medicine-list';
import { AddPrescriptionService } from '../services/add-prescription.service';
import { NavigationService } from '../services/navigation.service';
import { OrderBackend } from '../models/orderBackend';
import { commonService } from '../services/common.service';

@Component({
  selector: 'app-medicine-list',
  templateUrl: './medicine-list.component.html',
  styleUrls: ['./medicine-list.component.css']
})
export class MedicineListComponent implements OnInit {
  // medicinelist : medicineList[] = [
  //   {
  //       medicineName : "Dolo",
  //       supplierId : 1,
  //       manufactureDate: "2020-12-01",
  //       expDate: "2022-11-28" , 
  //       stock: 4,
  //       discount: 10,
  //       price: 25,
  //       quantity:0,
  //       finalPrice: 20
  //   },
  //   {
  //     medicineName : "Paracetamol",
  //     supplierId : 1,
  //     manufactureDate: "2020-12-01",
  //     expDate: "2022-11-28" , 
  //     stock: 100,
  //     discount: 10,
  //     price: 25,
  //     quantity:0,
  //     finalPrice: 20
  //   },
  //   {
  //     medicineName : "Crocin",
  //     supplierId : 1,
  //     manufactureDate: "2020-12-01",
  //     expDate: "2022-11-28" , 
  //     stock: 100,
  //     discount: 10,
  //     price: 25,
  //     quantity:0,
  //     finalPrice: 20
  //   }
  // ];

  medicinelist : medicineList[];

  sum:number=0;
  list:OrderBackend[];
  constructor(private common:commonService,private upload: AddPrescriptionService,private navigate:NavigationService) { 
    this.medicinelist = upload.medicines;
    for(let i=0 ; i<this.medicinelist.length ; i++){
      this.medicinelist[i].quantity=0;
    }
  }

  ngOnInit() {}

  increment(index){
    if(this.medicinelist[index].quantity<this.medicinelist[index].stock){
      this.medicinelist[index].quantity++;
      this.computeFinalPrice();
    } 

  }
  decrement(index){
    if(this.medicinelist[index].quantity>0){
      this.medicinelist[index].quantity--;
      this.computeFinalPrice();
    }

  }
  computeFinalPrice(){
    this.sum=0;
    for(let i=0;i<this.medicinelist.length;i++){
      this.sum=this.sum+(this.medicinelist[i].quantity)*(this.medicinelist[i].finalPrice);
    }
    console.log(this.sum);
  }
  onSubmit(){
    this.navigate.payment();
    for(let i=0;i<this.medicinelist.length;i++){
      this.list[i].medicineName=this.medicinelist[i].medicineName;
      this.list[i].finalPrice=this.medicinelist[i].finalPrice;
      this.list[i].quantity=this.medicinelist[i].quantity;
      this.list[i].supplierId=this.medicinelist[i].supplierId;
    }
    this.common.orderlist=this.list;
    console.log("medicine list"+this.medicinelist);
    console.log("common list"+this.common.orderlist);
  }

}