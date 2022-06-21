import { Component, OnInit } from '@angular/core';
import { StudentServiceService } from './student-service.service';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {
  getData:any[];
  constructor(private _httpService: StudentServiceService ) { }

  ngOnInit(): void {
  }
 

  
 

view_course(){

  this._httpService.viewcourse().subscribe((res : any[])=>{
           console.log(res);
           this.getData = res;

});
}
 



update_course(){
  var x=prompt("Enter student id");
  var y=prompt("Enter old course name");
  var z=prompt("Enter new course name");
  this._httpService.update(x,y,z).subscribe((res : any[])=>{
    console.log(res); 
})
}
}