import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserHomePageComponent } from './components/user-home-page/user-home-page.component';
import { LoginComponent } from './components/login/login.component';
import { ResigtrationComponent } from './components/resigtration/resigtration.component';
import { HttpClientModule  } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    UserHomePageComponent,
    LoginComponent,
    ResigtrationComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
