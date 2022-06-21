import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserComponent } from './user/user.component';
import { StudentComponent } from './student/student.component';

import { HttpClientModule } from '@angular/common/http';
import { CourseRegisterComponent } from './course-register/course-register.component';
import { DeleteCourseComponent } from './delete-course/delete-course.component';
import { AddCourseComponent } from './add-course/add-course.component';
import { ViewGradeComponent } from './view-grade/view-grade.component';
import { PayFeesComponent } from './pay-fees/pay-fees.component';
import { SignupComponent } from './signup/signup.component';

@NgModule({
  declarations: [
    AppComponent,
    UserComponent,
    StudentComponent,
    CourseRegisterComponent,
    DeleteCourseComponent,
AddCourseComponent,
ViewGradeComponent,
PayFeesComponent,
SignupComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
