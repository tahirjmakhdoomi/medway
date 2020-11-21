import { Component, OnInit,ViewChild,ElementRef } from "@angular/core";
import {
  FormGroup,
  FormControl,
  Validators,
  AbstractControl,
  FormArray,
  ValidatorFn,
  FormControlName
} from "@angular/forms";

import { UserModel } from "../models/userModel";
import { NavigationService } from '../services/navigation.service';
import { UserService } from "../services/user.service";
import { DuplicateEmailCheck } from "../Validators/duplicateEmailCheck";
import { DuplicatePhoneCheck } from '../Validators/duplicatePhone';
import { DuplicateUserNameCheck } from '../Validators/duplicateUserNameCheck';
import { MatchPasswords} from "../Validators/matchPasswords";
import Swal from 'sweetalert2/dist/sweetalert2.js'

declare var FB: any;
@Component({
  selector: "app-signup",
  templateUrl: "./signup.component.html",
  styleUrls: ["./signup.component.css"]
})
export class SignupComponent implements OnInit {
  signupForm : FormGroup;
  @ViewChild('loginRef', {}) loginElement: ElementRef;

  constructor(private _userServiceObj: UserService,private navigate : NavigationService) {}

  ngOnInit() {
    this.signupForm = new FormGroup({

      name : new FormControl(null,[Validators.required]),

      user_name: new FormControl(null, [
        Validators.required,],DuplicateUserNameCheck.checkUserName(this._userServiceObj)),

      user_email: new FormControl(
        null,
        [Validators.email, Validators.required,Validators.pattern("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.(com|in)$")],
         DuplicateEmailCheck.checkEmail(this._userServiceObj)
      ),

      password_group: new FormGroup(
        {
          user_password: new FormControl(null, [Validators.required,Validators.minLength(7)]),
          user_confirmPassword: new FormControl(null, [Validators.required])
        },
        [MatchPasswords.matchPasswords]
      ),

      user_phone: new FormControl(null,[Validators.required,Validators.min(1000000000),Validators.max(9999999999)],
      DuplicatePhoneCheck.checkPhone(this._userServiceObj)),


      supplierInfo_group:new FormGroup(
        {user_storeName : new FormControl(null),
          user_city : new FormControl(null),
          user_state : new FormControl(null),
          user_pin : new FormControl(null)
        }
      )
      
    });
    this.signupForm.get("user");

    //facebook login
    (window as any).fbAsyncInit = function() {
      FB.init({
        appId      : '2262299493914073',
        cookie     : true,
        xfbml      : true,
        version    : 'v3.1'
      });
      FB.AppEvents.logPageView();
    };
  
    (function(d, s, id){
       var js, fjs = d.getElementsByTagName(s)[0];
       if (d.getElementById(id)) {return;}
       js = d.createElement(s); js.id = id;
       js.src = "https://connect.facebook.net/en_US/sdk.js";
       fjs.parentNode.insertBefore(js, fjs);
     }(document, 'script', 'facebook-jssdk'));

     /*google login*/
     this.googleInitialize();
  }

  onSubmit() {

    this.navigate.loginIn();
    const userItem: UserModel = new UserModel(
      this.signupForm.get("name").value,
      this.signupForm.get("user_name").value,
      this.signupForm.get("user_email").value,
      this.signupForm.get("password_group").get("user_password").value,
      this.signupForm.get("user_phone").value,
      this.signupForm.get('supplierInfo_group').get("user_storeName").value,
      this.signupForm.get('supplierInfo_group').get("user_city").value,
      this.signupForm.get('supplierInfo_group').get("user_pin").value,
      this.signupForm.get('supplierInfo_group').get("user_state").value
    );

    this._userServiceObj.addUser(userItem).subscribe((data: any) => {this.signupForm.reset();},error => {});
    // alert("Registered Successfully!!!");
    Swal.fire({
          icon: 'success',
          title: 'Success',
          text: 'Welcome '+this.signupForm.get("name").value
        })
  }


  //Google login
  auth2:any;
  googleInitialize() {
    window['googleSDKLoaded'] = () => {
      window['gapi'].load('auth2', () => {
        this.auth2 = window['gapi'].auth2.init({
          client_id: '72148707537-etpdbp483gdlriiqr9mjpdcb9eesca1d.apps.googleusercontent.com',
          cookie_policy: 'single_host_origin',
          scope: 'profile email'
        });
        this.loginGoogle();
      });
    }
    (function(d, s, id){
      var js, fjs = d.getElementsByTagName(s)[0];
      if (d.getElementById(id)) {return;}
      js = d.createElement(s); js.id = id;
      js.src = "https://apis.google.com/js/platform.js?onload=googleSDKLoaded";
      fjs.parentNode.insertBefore(js, fjs);
    }(document, 'script', 'google-jssdk'));
  }


  flag1 : boolean = false;
  name: String = '';
  loginGoogle() {
    this.flag1 = true;
    this.auth2.attachClickHandler(this.loginElement.nativeElement, {},
      (googleUser) => {
        let profile = googleUser.getBasicProfile();
        console.log('Token || ' + googleUser.getAuthResponse().id_token);
        console.log(profile.getName());
        this.name = profile.getName();
        console.log('Image URL: ' + profile.getImageUrl());
        console.log('Email: ' + profile.getEmail());
        Swal.fire({
          icon: 'success',
          title: 'Success',
          text: 'Welcome '+this.name,
        })
      }, (error) => {
        alert(JSON.stringify(error, undefined, 2));
      });
  }

  goToHome(){
    if(this.name != null){
      this.navigate.home();
    }
  }


  checked : boolean =  false;
  supplierInfo(){
    this.checked = !this.checked;
    const name = this.signupForm.get('supplierInfo_group').get("user_storeName");
    const city = this.signupForm.get('supplierInfo_group').get("user_city");
    const pin = this.signupForm.get('supplierInfo_group').get("user_pin");
    const state = this.signupForm.get('supplierInfo_group').get("user_state");
    if(this.checked){
      name.setValidators(Validators.required);
      city.setValidators(Validators.required);
      pin.setValidators(Validators.required);
      state.setValidators(Validators.required);
    }
    else{
      name.clearValidators();
      city.clearValidators();
      pin.clearValidators();
      state.clearValidators();
    }
    name.updateValueAndValidity();
    city.updateValueAndValidity();
    pin.updateValueAndValidity();
    state.updateValueAndValidity();
  }

  fieldTextType : boolean = false;
  toggleFieldTextType(){
    this.fieldTextType = !this.fieldTextType;
  }

  fieldTextType1 : boolean = false;
  toggleFieldTextType1(){
    this.fieldTextType1 = !this.fieldTextType1;
  }


  //Facebook login
  var: any;
  checkStatus(){
    console.log("submit login to facebook");
    // FB.login();
    FB.login((response)=>
        {
          console.log('submitLogin',response);
          if (response.authResponse)
          {
            this.var = response.status;
            Swal.fire({
              icon: 'success',
              title: 'Success',
              text: 'You have registered succesfully!',
            })
          }
           else
           {
            Swal.fire({
              icon: 'error',
              title: 'Sorry!!!',
              text: 'Registration failed'
            })
          }
      });
        if(this.var == "connected"){
          this.navigate.home();
      }
  }

  login(){
    this.navigate.loginIn();
  }

  gotoHome(){
    this.navigate.home();
  }
    
}
