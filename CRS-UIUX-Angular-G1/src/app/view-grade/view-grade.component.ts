import { Component, OnInit } from '@angular/core';
import { Student} from '../student';
import {ViewserviceService} from './viewservice.service'
@Component({
  selector: 'app-view-grade',
  templateUrl: './view-grade.component.html',
  styleUrls: ['./view-grade.component.css']
})
export class ViewGradeComponent implements OnInit {

  newuser = new Student();
  constructor(private _httpService:ViewserviceService ) { }

  ngOnInit(): void {
  }
  view_grades(){
    
    this._httpService.viewgrades(this.newuser).subscribe((res : any[])=>{
      console.log(res); 
   })
  }
}
