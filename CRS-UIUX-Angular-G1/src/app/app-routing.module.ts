import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddCourseComponent } from './add-course/add-course.component';
import { CourseRegisterComponent } from './course-register/course-register.component';
import { DeleteCourseComponent } from './delete-course/delete-course.component';
import { PayFeesComponent } from './pay-fees/pay-fees.component';
import { SignupComponent } from './signup/signup.component';
import { StudentComponent } from './student/student.component';
import { UserComponent } from './user/user.component';
import { ViewGradeComponent } from './view-grade/view-grade.component';

const routes: Routes = [
  {path:'',redirectTo:'user',pathMatch:'full'},
  {path:'user',component:UserComponent},
  {path:'signup',component:SignupComponent},
  {path:'student',component:StudentComponent},
  {path:'addcourse',component:AddCourseComponent},
  {path:'deletecourse',component:DeleteCourseComponent},
  {path:'registercourse',component:CourseRegisterComponent},
  {path:'viewgrades',component:ViewGradeComponent},
  {path:'payment',component:PayFeesComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
