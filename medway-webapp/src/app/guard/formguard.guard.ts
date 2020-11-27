import { Injectable } from '@angular/core';
import { CanDeactivate } from '@angular/router';
import Swal from 'sweetalert2/dist/sweetalert2.js'
import { SignupComponent } from '../signup/signup.component';

@Injectable({
    providedIn: 'root'
  })
  export class FormGuard implements CanDeactivate<SignupComponent> {
    canDeactivate(component:SignupComponent):boolean{
      if(component.signupForm.invalid){
        return Swal.fire({
          title: 'Are you sure?',
          text: "You have some unsaved data!",
          icon: 'warning',
          showCancelButton: true,
          confirmButtonColor: '#3085d6',
          cancelButtonColor: '#d33',
          confirmButtonText: 'Yes'
        }).then((result) => {
          if (result.isConfirmed) {
           return true;
          }
        });
      }
      return true;
    }
  }