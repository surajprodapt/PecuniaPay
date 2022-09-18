import { Component, OnInit } from '@angular/core';
import { RegistrationServiceService } from 'src/app/registration-service.service';

@Component({
  selector: 'app-resigtration',
  templateUrl: './resigtration.component.html',
  styleUrls: ['./resigtration.component.css']
})
export class ResigtrationComponent implements OnInit {

  constructor(private userdata:RegistrationServiceService) { }

  ngOnInit(): void {
  }
  gerUserData(data :any){

this.userdata.saveuser(data).subscribe((result)=>{
  console.warn(result)
})
  }
}
