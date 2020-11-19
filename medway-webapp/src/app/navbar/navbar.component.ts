import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {

  constructor() { }

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
}
