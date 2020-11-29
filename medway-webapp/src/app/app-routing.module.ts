import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddPrescriptionComponent } from './add-prescription/add-prescription.component';
import { FormGuard } from './guard/formguard.guard';
import { LandingViewComponent } from './landing-view/landing-view.component';
import { LoginComponent } from './login/login.component';
import { MedicineListComponent } from './medicine-list/medicine-list.component';
import { OrderSummaryComponent } from './order-summary/order-summary.component';
import { SignupComponent } from './signup/signup.component';
import { UserTableComponent } from './user-table/user-table.component';
import { PaymentGatewayComponent } from './payment-gateway/payment-gateway.component';
import { PaymentComponent } from './payment/payment.component';

const routes: Routes = [
    {path : '',redirectTo : 'home',pathMatch: 'full'},
    {path : 'home' , component : LandingViewComponent},
    {path : 'signup' ,component : SignupComponent,canDeactivate:[FormGuard]},
    {path : 'login' , component: LoginComponent},
    {path : 'addmedicine' , component : UserTableComponent},
    {path : 'addprescription', component : AddPrescriptionComponent},
    {path : 'medicinelist' , component : MedicineListComponent},
    {path: 'orders', component: OrderSummaryComponent},
    {path:'payment',component:PaymentComponent},
    {path:'paymentGateway',component:PaymentGatewayComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
