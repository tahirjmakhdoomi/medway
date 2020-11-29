import { Component, OnInit } from '@angular/core';
import { HttpClient,HttpHeaders, HttpHeaderResponse } from '@angular/common/http';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { NavigationService } from '../services/navigation.service';
import { orderModel } from '../models/orderModel';
import { orderService } from '../services/order.service';
import Swal from 'sweetalert2/dist/sweetalert2.js'
import { DataService } from '../services/data.service';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {
  signupForm : FormGroup;
  constructor(private dataService:DataService,private _orderService:orderService, private httpClient:HttpClient,private navigate:NavigationService) { }

ngOnInit() {
  this.signupForm = new FormGroup({



    user_email: new FormControl(
      null,
      [Validators.email, Validators.required,Validators.pattern("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.(com|in)$")],
    ),

    user_phone: new FormControl(null,[Validators.required,Validators.min(1000000000),Validators.max(9999999999)]),
      paymentStatus:new FormControl(false),

    supplierInfo_group:new FormGroup(
      {user_address1 : new FormControl(null,[Validators.required]),
        user_address2:new FormControl(null,[Validators.required]),
        user_city : new FormControl(null,[Validators.required]),
        user_state : new FormControl(null,[Validators.required]),
        user_pin : new FormControl(null,[Validators.required])
      }
    )
    
  })

}
gotoHome(){
  this.navigate.home();
}
onSubmit() {
  
  this.navigate.paymentGateway();
  const orderItem: orderModel = new orderModel(
    this.signupForm.get("user_email").value,
    this.signupForm.get("user_phone").value,
    this.signupForm.get('supplierInfo_group').get("user_address1").value,
    this.signupForm.get('supplierInfo_group').get("user_address2").value,
    this.signupForm.get('supplierInfo_group').get("user_city").value,
    this.signupForm.get('supplierInfo_group').get("user_state").value,
    this.signupForm.get('supplierInfo_group').get("user_pin").value,

    this.signupForm.get("paymentStatus").value

  );
   this.data(orderItem);
   Swal.fire({
    icon: 'success',
    title: 'Success',
    text: 'Shipping address confirmed'
  });
  }
data(model:orderModel){
  this.dataService.order=model;
}
}
