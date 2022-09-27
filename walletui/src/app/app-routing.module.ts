import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AlldataComponent } from './components/alldata/alldata.component';
import { BalanceComponent } from './components/balance/balance.component';
import { CustomerComponent } from './components/customer/customer.component';
import { DatabyidComponent } from './components/databyid/databyid.component';
import { LoginComponent } from './components/login/login.component';
import { MainpageComponent } from './components/mainpage/mainpage.component';
import { MoneytransferComponent } from './components/moneytransfer/moneytransfer.component';
import { RegistrationComponent } from './components/registration/registration.component';
import { UserpageComponent } from './components/userpage/userpage.component';
import { UserprofileComponent } from './components/userprofile/userprofile.component';
import { WalletComponent } from './components/wallet/wallet.component';

const routes: Routes = [
  {
    component:RegistrationComponent,
    path:'register'
  },
  {
    component:UserpageComponent,
    path:'userpage'
  },
  {
    component:UserprofileComponent,
    path:'userprofile'
  },
  {
    component:WalletComponent,
    path:'wallet'
  },
  {
    component:MoneytransferComponent,
    path:'transfer'
  },
  {
    component:BalanceComponent,
    path:'balance'
  },
  {
    component:CustomerComponent,
    path:'customerid'
  },
  {
    component:AlldataComponent,
    path:'alldata'

  },
  {
    component:LoginComponent,
    path:'login'

  },
  {
    component:DatabyidComponent,
    path:'userid'

  },
  {
    component:MainpageComponent,
    path:'mainpage'

  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
