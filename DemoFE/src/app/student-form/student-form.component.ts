import { Component, OnInit, Input } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { StudentService } from '../service/student.service';
import { Student } from '../model/student';

@Component({
  selector: 'app-student-form',
  templateUrl: './student-form.component.html',
  styleUrls: ['./student-form.component.css']
})
export class StudentFormComponent {

  @Input() studentId: String;

  student: Student;

  constructor(private route: ActivatedRoute, private router: Router, private studentService: StudentService) {
    this.student = new Student();
  }


  ngOnInit() {
    this.route.paramMap.subscribe(params =>
      this.studentId = params.get('studentId'));

    this.studentService.findById(this.studentId)
      .subscribe(
        data => this.student = data);
  }

}
