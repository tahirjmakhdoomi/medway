import { Component, OnInit } from '@angular/core';
import { NavigationService } from '../services/navigation.service';
import Swal from 'sweetalert2/dist/sweetalert2.js'
import { Router } from '@angular/router';


@Component({
  selector: 'app-navbar-supplier',
  templateUrl: './navbar-supplier.component.html',
  styleUrls: ['./navbar-supplier.component.css']
})
export class NavbarSupplierComponent implements OnInit {
  constructor(private navigate:NavigationService) { }

  showcart=true;
  locationOn: boolean = false;
  searchOn: boolean = false;

  ngOnInit(): void {
    if(window.screen.width<640){
      this.showcart = false;
    }
  }

  searchText: String = "";

  searchClick(){
    console.log("Search Button Click");
  }
  gotoHome(){
    this.navigate.home();
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