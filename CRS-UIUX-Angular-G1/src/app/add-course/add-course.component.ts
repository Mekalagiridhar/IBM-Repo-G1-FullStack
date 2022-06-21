import { Component, OnInit } from '@angular/core';
import { Student} from '../student';
import {AddserviceService} from './addservice.service'

@Component({
  selector: 'app-add-course',
  templateUrl: './add-course.component.html',
  styleUrls: ['./add-course.component.css']
})
export class AddCourseComponent implements OnInit {
newuser = new Student();
  constructor(private _httpService:AddserviceService ) { }

  ngOnInit(): void {
  }
  add_course(){
    
    this._httpService.addcourse(this.newuser).subscribe((res : any[])=>{
      console.log(res); 
  })
  }
}
