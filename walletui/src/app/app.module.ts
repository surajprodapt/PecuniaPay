import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegistrationComponent } from './components/registration/registration.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import { AlldataComponent } from './components/alldata/alldata.component';
import { LoginComponent } from './components/login/login.component';
import { MainpageComponent } from './components/mainpage/mainpage.component';
import { DatabyidComponent } from './components/databyid/databyid.component';
import { CustomerComponent } from './components/customer/customer.component';
import { UserpageComponent } from './components/userpage/userpage.component';
import { UserprofileComponent } from './components/userprofile/userprofile.component';
import { MatButtonModule } from '@angular/material/button';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatDividerModule } from '@angular/material/divider';
import { MatMenuModule } from '@angular/material/menu';
import { MatIconModule } from '@angular/material/icon';
import{MatSidenavModule} from'@angular/material/sidenav';
import{MatToolbarModule} from'@angular/material/toolbar';
import{BrowserAnimationsModule}from'@angular/platform-browser/animations';
import { WalletComponent } from './components/wallet/wallet.component';
import { MoneytransferComponent } from './components/moneytransfer/moneytransfer.component';
import { BalanceComponent } from './components/balance/balance.component';







@NgModule({
  declarations: [
    AppComponent,
    RegistrationComponent,
    AlldataComponent,
    LoginComponent,
    MainpageComponent,
    DatabyidComponent,
    CustomerComponent,
    UserpageComponent,
    UserprofileComponent,
    WalletComponent,
    MoneytransferComponent,
    BalanceComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    MatButtonModule,
    MatInputModule,
    MatFormFieldModule,
    MatDividerModule,
    MatIconModule,
    MatMenuModule,
    MatSidenavModule,
    MatToolbarModule,
    BrowserAnimationsModule,
    
   
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
