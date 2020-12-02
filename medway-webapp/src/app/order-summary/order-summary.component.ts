import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { OrderBackend } from '../models/orderBackend';
import { OrderSummary } from '../models/orderSummary';
import { UserModel } from '../models/userModel';
import { AddPrescriptionService } from '../services/add-prescription.service';
import { UserService } from '../services/user.service';
import * as moment from 'moment/moment.js';

@Component({
  selector: 'app-order-summary',
  templateUrl: './order-summary.component.html',
  styleUrls: ['./order-summary.component.css']
})
export class OrderSummaryComponent implements OnInit {
  date:String[];
  constructor(private userService: UserService, private addPrescription: AddPrescriptionService,private route:ActivatedRoute) { }

  ngOnInit() {
    this.name = this.route.snapshot.queryParams.username;
    this.userService.getOrderSummary(this.name).subscribe(data => {
      this.user = data;
      this.orderSummaries = this.user.orderSummary;
      for(let i=0;i<this.orderSummaries.length;i++){
        this.orderSummaries[i].orderedOn = moment(this.user.orderSummary[i].orderedOn).format('DD/MM/YYYY');
      }
      console.log(this.user.orderSummary);
      console.log(this.user);
    })
  }

  orderSummaries: OrderSummary[];

  name: String;

  user: UserModel;

}
