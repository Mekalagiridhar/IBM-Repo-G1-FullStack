import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormGroup,FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { Signup } from './signup';
import {SignupserviceService} from './signupservice.service'

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  public message ="id not found";
  newsignup = new Signup();
    constructor(private _httpService:SignupserviceService,private router: Router) { }

  ngOnInit(): void {
  }
 newuser(){
  this._httpService.sign_up(this.newsignup).subscribe((res : any)=>{
    console.log(res);
    if(res.message == 'true'){
      this.router.navigate(['user']);
    }
    else if(res.message == 'false'){
     alert(this.message);
  }
  });
 }
  
}
//[FormGroup]="signupForm" (ngSubmit)="signUp()"