import { Component, OnInit } from '@angular/core';
import { AddPrescriptionService } from '../services/add-prescription.service';
import { NavigationService } from '../services/navigation.service';
import Swal from 'sweetalert2/dist/sweetalert2.js'
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {

  username;
  constructor(private navigate:NavigationService,private upload : AddPrescriptionService,private router : Router) { }
  ngOnInit(): void {
    this.username = this.upload.username;
  }

  
  gotoHome(){
    this.navigate.home();
  }

  gotoOrders(){
    this.navigate.orderSummary();
  }

  logout(){
    Swal.fire({
      title: 'Are you sure?',
      text: "You won't be able to revert this!",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Yes'
    }).then((result) => {
      if (result.isConfirmed) {
        Swal.fire(
          'Done!',
          'You have been succesfully logged out.',
          'success'
        )
        this.navigate.loginIn();
      }
    })

  }
}
