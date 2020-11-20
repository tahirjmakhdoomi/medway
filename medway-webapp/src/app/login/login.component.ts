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

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;
  
  constructor(private userService: LoginService,
              private navigate : NavigationService) {
     
  }

  ngOnInit(): void {
    this.loginForm=new FormGroup({
      password_group:new FormGroup(
        {
          user_password:new FormControl(null,[Validators.required,Validators.minLength(7)]),
        }
      ),
      user_phone:new FormControl(null,[Validators.required,Validators.minLength(10)]),
    });
  }
  onSubmit(){
    
    const user:LoginModel=new LoginModel(
      this.loginForm.get('user_phone').value,
      this.loginForm.get('user_password').value
    );
    this.userService.postUserData(user).subscribe(resp=>{
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
    this.navigate.gotoHome();
  }

}
