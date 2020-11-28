import { Component, OnInit, APP_INITIALIZER } from '@angular/core';
import { medicineList } from '../models/medicine-list';

@Component({
  selector: 'app-medicine-list',
  templateUrl: './medicine-list.component.html',
  styleUrls: ['./medicine-list.component.css']
})
export class MedicineListComponent implements OnInit {
  medicinelist : medicineList[] = [
    {
        medicineName : "Dolo",
        supplierId : 1,
        manufactureDate: "2020-12-01",
        expDate: "2022-11-28" , 
        stock: 4,
        discount: 10,
        price: 25,
        quantity:0,
        finalPrice: 20
    },
    {
      medicineName : "Paracetamol",
      supplierId : 1,
      manufactureDate: "2020-12-01",
      expDate: "2022-11-28" , 
      stock: 100,
      discount: 10,
      price: 25,
      quantity:0,
      finalPrice: 20
    },
    {
      medicineName : "Crocin",
      supplierId : 1,
      manufactureDate: "2020-12-01",
      expDate: "2022-11-28" , 
      stock: 100,
      discount: 10,
      price: 25,
      quantity:0,
      finalPrice: 20
    }
  ];
  sum:number=0;
  constructor() { }

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

}
