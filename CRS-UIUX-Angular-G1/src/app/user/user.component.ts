import { Component, OnInit } from '@angular/core';
import { User } from './user';
import { UserserviceService } from './userservice.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  public message ="id not found";
user = new User();
  constructor(private _httpService:UserserviceService,private router: Router) { }

  ngOnInit(): void {
  }

  login(){
    this._httpService.log_in(this.user).subscribe((res : any)=>{
      console.log(res);
      if(res.message == 'true'){
        this.router.navigate(['student']);
      }
      else if(res.message == 'false'){
       alert(this.message);
    }
    });
  }

}
