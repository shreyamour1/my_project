import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { credentials } from '../model/credentials';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private loginUrl: string;

  constructor(private http: HttpClient) {
    this.loginUrl = 'http://localhost:1122/login';
  }

  public login(creds: credentials): Observable<string> {
    return this.http.post<string>(this.loginUrl, creds);
  }
}
