import { Injectable } from '@angular/core';
import { Student } from '../model/student';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

    private studentsUrl: string;
 
  constructor(private http: HttpClient) {
    this.studentsUrl = 'http://localhost:1122/student';
  }
 
  public findAll(): Observable<Student[]> {
    return this.http.get<Student[]>(this.studentsUrl);
  }

  public findById(id: String): Observable<Student> {
    return this.http.get<Student>(this.studentsUrl+'/'+id);
  }
 
  public save(student: Student) {
    return this.http.post<Student>(this.studentsUrl, student,null);
  }

}
