import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NavigationService } from '../services/navigation.service';

@Component({
  selector: 'app-landing-view',
  templateUrl: './landing-view.component.html',
  styleUrls: ['./landing-view.component.scss']
})
export class LandingViewComponent implements OnInit {

  constructor() { }

  isMobileView: boolean = false;
  ngOnInit(): void {
    if(window.screen.width<640){
      this.isMobileView = true;
    }
  }

  logIn(){

  }

  signUp(){
   
  }

}
