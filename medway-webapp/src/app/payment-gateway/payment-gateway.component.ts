import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import Swal from 'sweetalert2/dist/sweetalert2.js'
import { NavigationService } from '../services/navigation.service';
import { orderService } from '../services/order.service';
import { DataService } from '../services/data.service';
import { orderModel } from '../models/orderModel';

@Component({
  selector: 'app-payment-gateway',
  templateUrl: './payment-gateway.component.html',
  styleUrls: ['./payment-gateway.component.css']
})
export class PaymentGatewayComponent implements OnInit {
  signupForm : FormGroup;

  constructor(private dataService:DataService,private navigate:NavigationService,private _orderService:orderService) { }

  ngOnInit() {
    this.signupForm = new FormGroup({
          cardNumber : new FormControl(null,[Validators.required,Validators.min(1000000000000000),Validators.max(9999999999999999)]),
          expMonth:new FormControl(null,[Validators.required,Validators.min(1),Validators.max(12)]),
          expYear : new FormControl(null,[Validators.required,Validators.min(2021),Validators.max(3000)]),
          cvv : new FormControl(null,[Validators.required,Validators.min(1),Validators.max(999)])
        })
  }
  onSubmit(){
    this.navigate.home();
    const orderItem:orderModel=this.dataService.order;
    this.dataService.order.paymentStatus=true;
    this._orderService.addUser(orderItem).subscribe((data: any) => {this.signupForm.reset();
      Swal.fire({
        icon: 'success',
        title: 'Success',
        text: 'Order Placed'
      })},error => {
        Swal.fire({
          icon: 'error',
          title: 'Oops',
          text: error
        })
      });
  }
}
