import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { HttpHeaders } from '@angular/common/http';
import { Student} from '../student';
@Injectable({
  providedIn: 'root'
})
export class DeleteserviceService {

  headers = new HttpHeaders().set('Content-Type', 'application/json').set('Access-Control-Allow-Origin','*');
  constructor(private httpClient:HttpClient) { }

  deletecourse(ad : Student): Observable<any>{
    let getdeleteUrl:string ="http://localhost:8080/student/delete/course";
    return this.httpClient.post(`${getdeleteUrl}/${ad.id}`,{headers: this.headers});
  }
}
