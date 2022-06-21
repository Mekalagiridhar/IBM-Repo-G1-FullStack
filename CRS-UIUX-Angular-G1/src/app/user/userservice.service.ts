import { HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {User} from'./user';

@Injectable({
  providedIn: 'root'
})
export class UserserviceService {
  headers = new HttpHeaders().set('Content-Type', 'application/json').set('Access-Control-Allow-Origin','*');
  constructor(private httpClient:HttpClient) { }
  log_in(user : User): Observable<any>{
    let getloginurl:string="http://localhost:8080/user/username";
    return this.httpClient.post(`${getloginurl}/${user.name}/${user.password}`,{headers:this.headers})
  }
}
