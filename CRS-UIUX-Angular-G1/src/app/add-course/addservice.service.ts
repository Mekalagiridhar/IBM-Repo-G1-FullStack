import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { HttpHeaders } from '@angular/common/http';
import { Student} from '../student';
@Injectable({
  providedIn: 'root'
})
export class AddserviceService {

  headers = new HttpHeaders().set('Content-Type', 'application/json').set('Access-Control-Allow-Origin','*');
  constructor(private httpClient:HttpClient) { }

  addcourse(ad : Student): Observable<any>{
    let getaddurl:string="http://localhost:8080/student/post/addnewcourse";
    return this.httpClient.post(`${getaddurl}/${ad.id}/${ad.course}`,{headers:this.headers})
  }
}
