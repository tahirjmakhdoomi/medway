import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import Swal from 'sweetalert2/dist/sweetalert2.js'
import { NavigationService } from '../services/navigation.service';
import { orderService } from '../services/order.service';
import { DataService } from '../services/data.service';
import { orderModel } from '../models/orderModel';
import { commonService } from '../services/common.service';
import { Router } from '@angular/router';
import { AddPrescriptionService } from '../services/add-prescription.service';
import { HttpHeaders, HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-payment-gateway',
  templateUrl: './payment-gateway.component.html',
  styleUrls: ['./payment-gateway.component.css']
})
export class PaymentGatewayComponent implements OnInit {
  signupForm : FormGroup;

  constructor(private http:HttpClient,private dataService:DataService,private navigate:NavigationService,private _orderService:orderService,private common : commonService,private route:Router,private upload:AddPrescriptionService) { }
  sum : number=0;
  ngOnInit() {
    this.signupForm = new FormGroup({
          cardNumber : new FormControl(null,[Validators.required,Validators.min(1000000000000000),Validators.max(9999999999999999)]),
          expMonth:new FormControl(null,[Validators.required,Validators.min(1),Validators.max(12)]),
          expYear : new FormControl(null,[Validators.required,Validators.min(2021),Validators.max(3000)]),
          cvv : new FormControl(null,[Validators.required,Validators.min(1),Validators.max(999)])
        })
        this.sum = this.common.total;
  }
  onSubmit(){
    console.log(this.signupForm.value);
    (<any>window).Stripe.card.createToken({
      number: this.signupForm.get('cardNumber').value,
      exp_month: this.signupForm.get('expMonth').value,
      exp_year: this.signupForm.get('expYear').value,
      cvc: this.signupForm.get('cvv').value
    }, (status: number, response: any) => {
      if (status === 200) {
        let token = response.id;
        this.chargeCard(token);
        console.log(token);
      } else {
        console.log(response.error.message);
      }
    });
    const orderItem:orderModel=this.dataService.order;
    this.dataService.order.paymentStatus=true;
    console.log(orderItem);
    this._orderService.addUser(orderItem).subscribe((data: any) => {this.signupForm.reset();
      Swal.fire({
        icon: 'success',
        title: 'Success',
        text: 'Order Placed'
      })
      this.route.navigate([`/orders`],{queryParams : {'username' : this.upload.username}});
    },error => {
        Swal.fire({
          icon: 'error',
          title: 'Oops',
          text: error
        })
      });
  }


  chargeCard(token: string) {
    const headers = new HttpHeaders({ 'token': token, 'amount': this.sum.toString(),'username':this.upload.username.toString(),'email':this.dataService.order.user_email.toString() })
    this.http.post('http://localhost:8300/payment/charge', {}, {headers})
      .subscribe(resp => {
        console.log(resp);
      })
  }
}
