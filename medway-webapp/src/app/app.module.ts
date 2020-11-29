import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { SignupComponent } from './signup/signup.component';
import { DialogComponent } from './dialog/dialog.component';
import { UserService } from './services/user.service';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NavbarComponent } from './navbar/navbar.component';
import{ MatButtonModule,MatIconModule,MatProgressBarModule,MatTableModule,MatListModule,MatDialogModule } from '@angular/material';
import {MatBadgeModule} from '@angular/material/badge';
import { MatInputModule } from '@angular/material/input';
import {MatDatepickerModule} from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import { MatSelectModule } from '@angular/material/select';
import {MatSidenavModule} from '@angular/material/sidenav';
import { LandingViewComponent } from './landing-view/landing-view.component';
import { NavigationService } from './services/navigation.service';
import { LoginComponent } from './login/login.component';
import { UserTableComponent } from './user-table/user-table.component';
import { AddPrescriptionComponent } from './add-prescription/add-prescription.component';
import { FlexLayoutModule } from '@angular/flex-layout';
import { NavbarSupplierComponent } from './navbar-supplier/navbar-supplier.component';


@NgModule({
  declarations: [
    AppComponent,
    SignupComponent,
    LandingViewComponent,
    NavbarComponent,
    LoginComponent,
    UserTableComponent,
    AddPrescriptionComponent,
    DialogComponent,
    NavbarSupplierComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MatSidenavModule,
    FormsModule,
    AppRoutingModule,
    MatBadgeModule,
    MatInputModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatButtonModule,
    MatIconModule,
    MatSelectModule,
    MatProgressBarModule,
    MatTableModule,
    MatListModule,
    FlexLayoutModule,
    MatDialogModule
  ],
  entryComponents: [DialogComponent],
  providers: [UserService,NavigationService],
  bootstrap: [AppComponent]
})
export class AppModule { }
