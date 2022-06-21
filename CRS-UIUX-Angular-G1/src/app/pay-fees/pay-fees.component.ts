import { Component, OnInit } from '@angular/core';
import { Student} from '../student';
import {PayserviceService} from './payservice.service'
@Component({
  selector: 'app-pay-fees',
  templateUrl: './pay-fees.component.html',
  styleUrls: ['./pay-fees.component.css']
})
export class PayFeesComponent implements OnInit {

  newuser = new Student();
  constructor(private _httpService:PayserviceService ) { }

  ngOnInit(): void {
  }

  pay_fee(){
    
    this._httpService.fees(this.newuser).subscribe((res : any[])=>{
      console.log(res); 
  })
  }
}
