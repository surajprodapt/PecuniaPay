import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { ResigtrationComponent } from './components/resigtration/resigtration.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'registration', component: ResigtrationComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  providers: []
})
export class AppRoutingModule { }
