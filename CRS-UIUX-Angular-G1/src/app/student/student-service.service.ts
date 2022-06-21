import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class StudentServiceService {

  headers = new HttpHeaders().set('Content-Type', 'application/json').set('Access-Control-Allow-Origin','*');
  constructor(private httpClient:HttpClient) { }
 

  viewcourse(): Observable<any>{
    let getStudentUrl:string = "http://localhost:8080/student/viewcourse";
    return this.httpClient.get(getStudentUrl,{headers: this.headers});
  }
   
 
 

  update(id : any,courseold : any,coursenew : any): Observable<any>{
    let getupdateUrl:string ="http://localhost:8080/student/update/course";
    return this.httpClient.post(`${getupdateUrl}/${id}/${courseold}/${coursenew}`,{headers: this.headers});
  }
}
//<a (click)="update_course()">Update course</a>