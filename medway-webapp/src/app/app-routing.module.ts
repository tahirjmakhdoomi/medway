import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddPrescriptionComponent } from './add-prescription/add-prescription.component';
import { FormGuard } from './guard/formguard.guard';
import { LandingViewComponent } from './landing-view/landing-view.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { UserTableComponent } from './user-table/user-table.component';

const routes: Routes = [
    {path : '',redirectTo : 'home',pathMatch: 'full'},
    {path : 'home' , component : LandingViewComponent},
    {path : 'signup' ,component : SignupComponent,canDeactivate:[FormGuard]},
    {path : 'login' , component: LoginComponent},
    {path : 'addmedicine' , component : UserTableComponent},
    {path : 'addprescription', component : AddPrescriptionComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
