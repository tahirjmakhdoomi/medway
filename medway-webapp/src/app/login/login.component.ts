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

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;
  message : any;
  
  constructor(private userService: LoginService,
              private navigate : NavigationService) {
     
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
      this.loginForm.get('user_password').value
    );
    this.userService.postUserData(user).subscribe(resp=>{
      if(resp == "Success"){
          Swal.fire({
          icon: 'success',
          title: resp,
          text: 'Logged in successfully'});
      }
      else{
        Swal.fire({
          icon: 'error',
          title: 'Oops',
          text: resp});
      }
    })
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
