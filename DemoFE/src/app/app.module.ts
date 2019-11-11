import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { StudentFormComponent } from './student-form/student-form.component';
import { StudentService } from './service/student.service';
import { HttpClientModule } from '@angular/common/http';
import { LoginFormComponent } from './login-form/login-form.component';
import { LoginService } from './service/login.service';
import { UniversityFormComponent } from './university-form/university-form.component';

@NgModule({
  declarations: [
    AppComponent,
    StudentFormComponent,
    LoginFormComponent,
    UniversityFormComponent
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FormsModule
  ],
  providers: [StudentService,LoginService],
  bootstrap: [AppComponent]
})
export class AppModule { }
