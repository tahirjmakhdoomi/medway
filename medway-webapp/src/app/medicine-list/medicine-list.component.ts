import { Component, OnInit } from '@angular/core';
import { medicineList } from '../models/medicine-list';

@Component({
  selector: 'app-medicine-list',
  templateUrl: './medicine-list.component.html',
  styleUrls: ['./medicine-list.component.css']
})
export class MedicineListComponent implements OnInit {
  medicineList : medicineList[] = [
    {
        medicineName : "Dolo",
        supplierId : 1,
        manufactureDate: "2020-12-01",
        expDate: "2022-11-28" , 
        stock: 100,
        discount: 10,
        price: 25,
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
      finalPrice: 20
}
];
count:number[];

  constructor() { }

  ngOnInit() {
  }

  increment(index){
    this.count[index]++;
  }
  decrement(index){
    this.count[index]--;
  }

}
