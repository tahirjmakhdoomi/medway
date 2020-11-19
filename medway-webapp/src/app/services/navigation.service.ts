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

}
