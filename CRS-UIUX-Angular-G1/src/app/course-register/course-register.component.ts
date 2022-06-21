import { Component, OnInit } from '@angular/core';
import { Student} from '../student';
import {RegisterserviceService} from './registerservice.service'
@Component({
  selector: 'app-course-register',
  templateUrl: './course-register.component.html',
  styleUrls: ['./course-register.component.css']
})
export class CourseRegisterComponent implements OnInit {

  newuser = new Student();
  constructor(private _httpService:RegisterserviceService ) { }

  ngOnInit(): void {
  }

  course_register(){
   
    this._httpService.courseregistration(this.newuser).subscribe((res)=>{
      console.log(res);
    })
  }

}
