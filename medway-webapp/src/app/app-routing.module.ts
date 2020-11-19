import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LandingViewComponent } from './landing-view/landing-view.component';
import { NavbarComponent } from './navbar/navbar.component';
import { SignupComponent } from './signup/signup.component';

const routes: Routes = [
    {path:'', redirectTo: '/home', pathMatch:"full"},
    {path: 'home', component: LandingViewComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
