import { Component, OnInit } from '@angular/core';
import { NavigationService } from '../services/navigation.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {

<<<<<<< HEAD
  constructor(private navigate: NavigationService) { }
=======
  constructor(private navigate:NavigationService) { }
>>>>>>> 9baee6cb050b39ac8ed724805cdf542ece251036

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
}
