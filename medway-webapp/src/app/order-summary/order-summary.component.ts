import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { OrderBackend } from '../models/orderBackend';
import { OrderSummary } from '../models/orderSummary';
import { UserModel } from '../models/userModel';
import { AddPrescriptionService } from '../services/add-prescription.service';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-order-summary',
  templateUrl: './order-summary.component.html',
  styleUrls: ['./order-summary.component.css']
})
export class OrderSummaryComponent implements OnInit {

  constructor(private userService: UserService, private addPrescription: AddPrescriptionService,private route:ActivatedRoute) { }

  ngOnInit() {
    this.name = this.route.snapshot.queryParams.username;
    this.userService.getOrderSummary(this.name).subscribe(data => {
      this.user = data;
      this.orderSummaries = this.user.orderSummary;
      console.log(this.user.orderSummary);
      console.log(this.user);
    })
  }

  orderSummaries: OrderSummary[];

  name: String;

  user: UserModel;

}
