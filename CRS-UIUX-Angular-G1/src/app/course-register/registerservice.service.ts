import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { HttpHeaders } from '@angular/common/http';
import { Student} from '../student';
@Injectable({
  providedIn: 'root'
})
export class RegisterserviceService {

  headers = new HttpHeaders().set('Content-Type', 'application/json').set('Access-Control-Allow-Origin','*');
  constructor(private httpClient:HttpClient) { }

  courseregistration(ad : Student): Observable<any>{
    let getregurl:string="http://localhost:8080/student/register";
    return this.httpClient.post(`${getregurl}/${ad.id}/${ad.studentid}/${ad.course1}/${ad.course2}/${ad.course3}/${ad.course4}`,{headers:this.headers})
      }
}
