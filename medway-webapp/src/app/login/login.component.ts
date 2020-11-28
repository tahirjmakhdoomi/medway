import { Component, OnInit } from '@angular/core';
import {
  FormGroup,
  FormControl,
  Validators,
  AbstractControl,
  FormArray,
  ValidatorFn,
  FormControlName
} from "@angular/forms";

import {LoginModel} from "../models/loginModel";
import {LoginService} from "../services/login.service";
import { NavigationService } from '../services/navigation.service';
import Swal from 'sweetalert2/dist/sweetalert2.js'
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;
  
  constructor(private userService: LoginService,
              private navigate : NavigationService,
              private router : Router) {
     
  }

  ngOnInit(): void {
    this.loginForm=new FormGroup({
      password_group:new FormGroup(
        {
          user_password:new FormControl(null,[Validators.required]),
        }
      ),
      user_name:new FormControl(null,[Validators.required]),
    });
  }
  onSubmit(){
    
    const user:LoginModel=new LoginModel(
      this.loginForm.get('user_name').value,
      this.loginForm.get('password_group').get('user_password').value
    );
    console.log(user)
    this.userService.postUserData(user).subscribe(resp=>{
      if(resp === "Success"){
        console.log(resp);
        Swal.fire({
          icon: 'success',
          title: resp,
          text: 'Logged in successfully'});
          this.router.navigate([`/addprescription`],{queryParams : {'username' : user.user_name}});
      }},error => Swal.fire({
        icon: 'error',
        title: 'Oops',
        text: 'Invalid Credentials'}))
  }
  
  checked : boolean =  false;
  
  fieldTextType : boolean = false;
  toggleFieldTextType(){
    this.fieldTextType = !this.fieldTextType;
  }

  signUp(){
    this.navigate.signUp();
  }

  goToHome(){
    this.navigate.home();
  }

}
