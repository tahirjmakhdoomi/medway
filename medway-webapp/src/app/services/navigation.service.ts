import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { SignupComponent } from '../signup/signup.component';

@Injectable({
  providedIn: 'root'
})
export class NavigationService {

  constructor(private router: Router) { }

  signUp(){
    this.router.navigate(['/signup']);
  }

  loginIn(){
    this.router.navigate(['/login']);
  }

<<<<<<< HEAD
  gotoHome(){
=======
  home(){
>>>>>>> 13f14012adb8b5fbad4df2025a67b56987dfcb70
    this.router.navigate(['/home']);
  }

}
