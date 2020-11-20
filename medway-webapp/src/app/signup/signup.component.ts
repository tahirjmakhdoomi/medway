import { Component, OnInit } from "@angular/core";
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

@Component({
  selector: "app-signup",
  templateUrl: "./signup.component.html",
  styleUrls: ["./signup.component.css"]
})
export class SignupComponent implements OnInit {
  signupForm : FormGroup;

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
    this.signupForm.get("user")
  }

  onSubmit() {


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

  login(){
    this.navigate.loginIn();
  }

  gotoHome(){
    this.navigate.gotoHome();
  }
    
}
