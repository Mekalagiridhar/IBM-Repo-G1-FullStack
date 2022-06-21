import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { HttpHeaders } from '@angular/common/http';
import { Student} from '../student';
@Injectable({
  providedIn: 'root'
})
export class PayserviceService {

  headers = new HttpHeaders().set('Content-Type', 'application/json').set('Access-Control-Allow-Origin','*');
  constructor(private httpClient:HttpClient) { }

  fees(ad : Student): Observable<any>{
    let getfeeUrl:string ="http://localhost:8080/student/payfee";
    return this.httpClient.post(`${getfeeUrl}/${ad.id}/${ad.amount}/${ad.paytype}`,{headers: this.headers});
  }
}
