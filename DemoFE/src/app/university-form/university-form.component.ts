import { Component, OnInit, Input } from '@angular/core';
import { University } from '../model/University';
import { ActivatedRoute, Router } from '@angular/router';
import { UniversityService } from '../service/university.service';

@Component({
  selector: 'app-university-form',
  templateUrl: './university-form.component.html',
  styleUrls: ['./university-form.component.css']
})
export class UniversityFormComponent implements OnInit {

  @Input() universityId: string;

  university: University;

  constructor(private route: ActivatedRoute, private router: Router, private universityService: UniversityService) {
    this.university = new University();
  }

  ngOnInit() {
    this.route.paramMap.subscribe(params =>
      this.universityId= params.get('universityId'));

    this.universityService.findById(this.universityId)
    .subscribe(
      data => this.university = data);
  }

}
