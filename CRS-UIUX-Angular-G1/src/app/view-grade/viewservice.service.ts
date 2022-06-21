import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { HttpHeaders } from '@angular/common/http';
import { Student} from '../student';
@Injectable({
  providedIn: 'root'
})
export class ViewserviceService {

  headers = new HttpHeaders().set('Content-Type', 'application/json').set('Access-Control-Allow-Origin','*');
  constructor(private httpClient:HttpClient) { }

  viewgrades(ad : Student): Observable<any>{
    let getgradeurl:string="http://localhost:8080/student/viewreport";
    return this.httpClient.get(`${getgradeurl}/${ad.id}`,{headers:this.headers})
  }
}
