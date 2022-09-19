import { Component, OnInit } from '@angular/core';
import { RegistrationServiceService } from 'src/app/registration-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private userlogin:RegistrationServiceService) { }

  ngOnInit(): void {
  }
  gerloginData(data :any){

    this.userlogin.savelogin(data).subscribe((result)=>{
      console.warn(result)
    })
      }
}
