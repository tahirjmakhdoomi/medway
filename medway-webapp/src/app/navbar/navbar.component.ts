import { Component, OnInit } from '@angular/core';
import { AddPrescriptionService } from '../services/add-prescription.service';
import { NavigationService } from '../services/navigation.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {

  username;
  constructor(private navigate:NavigationService,private upload : AddPrescriptionService) { }
  ngOnInit(): void {
    this.username = this.upload.username;
  }

  
  gotoHome(){
    this.navigate.home();
  }
}
