import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PaymentformComponent } from './paymentform/paymentform.component';
import { PremiumDueComponent } from './premium-due/premium-due.component';
import { PremiumHistoryComponent } from './premium-history/premium-history.component';
import { HomeComponent } from './home/home.component'

const routes: Routes = [
  {
    path:'',
    component: HomeComponent
  },
  {
    path: 'paymentform',
    component: PaymentformComponent
  },
  {
    path: 'premium-history',
    component: PremiumHistoryComponent
  },
  {
    path: 'premium-due',
    component: PremiumDueComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
