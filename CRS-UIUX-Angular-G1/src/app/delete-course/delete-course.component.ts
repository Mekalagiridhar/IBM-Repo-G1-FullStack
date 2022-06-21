import { Component, OnInit } from '@angular/core';
import { Student} from '../student';
import {DeleteserviceService} from './deleteservice.service';

@Component({
  selector: 'app-delete-course',
  templateUrl: './delete-course.component.html',
  styleUrls: ['./delete-course.component.css']
})
export class DeleteCourseComponent implements OnInit {

  newuser = new Student();
  constructor(private _httpService:DeleteserviceService ) { }

  ngOnInit(): void {
  }
  delete_course(){
   
    this._httpService.deletecourse(this.newuser).subscribe((res : any[])=>{
      console.log(res); 
   })
  }

}
