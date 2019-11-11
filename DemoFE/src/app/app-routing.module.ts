import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { StudentFormComponent } from './student-form/student-form.component';
import { LoginFormComponent } from './login-form/login-form.component';
import { UniversityFormComponent } from './university-form/university-form.component';


const routes: Routes = [
  { path: 'login', component: LoginFormComponent },
  { path: 'student/:studentId', component: StudentFormComponent },
  { path: 'student/:studentId/university/:universityId', component: UniversityFormComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }