import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { University } from '../model/University';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UniversityService {

  private universityUrl: string;
 
  constructor(private http: HttpClient) {
    this.universityUrl = 'http://localhost:1122/university';
  }

  public findById(id: string): Observable<University> {
    return this.http.get<University>(this.universityUrl +'/'+id);
  }
}
