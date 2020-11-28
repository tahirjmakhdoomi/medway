import { Component, OnInit, APP_INITIALIZER } from '@angular/core';
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
        stock: 4,
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
count:number[] = new Array(medicineList.length);

  constructor() { }

  ngOnInit() {
    for(let i = 0;i<this.count.length;i++) {  
      this.count[i]=0 ;
    }

  }

  increment(index){
    if(this.count[index]<this.medicineList[index].stock)
    this.count[index]++;
  }
  decrement(index){
    if(this.count[index]>0)
      this.count[index]--;
  }

}
