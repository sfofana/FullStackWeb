import { UserService } from '../../services/user.service';
import { ValidationService } from '../../services/validation.service';
import { Profile } from '../../models/profile';
import { SubjectService } from '../../services/subject.service';
import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  profile: Profile = {} as Profile;
  message: string;

  constructor(private service: UserService, private validation: ValidationService, private memory: SubjectService, private router: Router) { }

  ngOnInit(): void {
  }

  login() {
    this.service.login(this.profile).subscribe(
      data => {
      this.memory.setSession(data);
      this.router.navigate(['dashboard']);
    },
      error => this.message = error.message,
      () => this.reset()
    );
  }

  reset() {
    this.profile = {} as Profile;
    this.message = "";
  }
}
