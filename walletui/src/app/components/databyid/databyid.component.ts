import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-databyid',
  templateUrl: './databyid.component.html',
  styleUrls: ['./databyid.component.css']
})
export class DatabyidComponent implements OnInit {
Regis:any
  constructor(private http:HttpClient) { }

  ngOnInit(): void {
    let response=this.http.get("http://localhost:8060/login/users/getuser/1");
    response.subscribe((data)=>this.Regis=data);
  }

}
