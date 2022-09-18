import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class RegistrationServiceService {

  url='http://localhost:3000/users ';
  urllogin='http://localhost:3000/users ';
  constructor(private http : HttpClient) { }

   

  saveuser(data :any){
       return this.http.post(this.url,data);
    }
    savelogin(data :any){
      return this.http.post(this.url,data);
   }
}
