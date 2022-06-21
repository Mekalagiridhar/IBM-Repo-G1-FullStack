import { HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Signup } from './signup';

@Injectable({
  providedIn: 'root'
})
export class SignupserviceService {

  headers = new HttpHeaders().set('Content-Type', 'application/json').set('Access-Control-Allow-Origin','*');
  constructor(private httpClient:HttpClient) { }

  sign_up(signup :Signup): Observable<any>{
    let getsignupurl:string="http://localhost:8080/user/newuser";
    return this.httpClient.post(`${getsignupurl}/${signup.email}/${signup.name}/${signup.password}`,{headers:this.headers})
  }
}
