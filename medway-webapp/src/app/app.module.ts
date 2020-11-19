import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { SignupComponent } from './signup/signup.component';
import { UserService } from './services/user.service';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NavbarComponent } from './navbar/navbar.component';

import {MatSidenavModule} from '@angular/material/sidenav';
import { LandingViewComponent } from './landing-view/landing-view.component';


@NgModule({
  declarations: [
    AppComponent,
    SignupComponent,
    LandingViewComponent,
    NavbarComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MatSidenavModule,
    FormsModule 
  ],
  providers: [UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
