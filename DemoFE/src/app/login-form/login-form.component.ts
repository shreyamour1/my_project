import { Component, OnInit } from '@angular/core';
import { credentials } from '../model/credentials';
import { ActivatedRoute, Router } from '@angular/router';
import { LoginService } from '../service/login.service';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent {

   credentials: credentials;

  constructor(private route: ActivatedRoute, private router: Router, private loginService: LoginService) {
    this.credentials = new credentials();
  }

  onLogin() {
    this.loginService.login(this.credentials).subscribe(result => {
      this.gotoLogin()
    });
  }

  gotoLogin() {
    var success = this.router.navigate(['/login']);
    if(success){
      this.router.navigate(['/student',this.credentials.studentId]);
    }else{

    }
    
  }

}
