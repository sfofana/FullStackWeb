import { UserService } from '../../services/user.service';
import { ValidationService } from '../../services/validation.service';
import { Profile } from '../../models/profile';
import { SubjectService } from '../../services/subject.service';
import { AccountHolder } from '../../models/account-holder';
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
  validEmail: boolean = true;

  constructor(private service: UserService, private validation: ValidationService, private memory: SubjectService, private router: Router) { }

  ngOnInit(): void {
  }

  login(): AccountHolder {
    let holder: AccountHolder;
    this.service.login(this.profile).subscribe(
      data => {
      this.memory.setSession(data);
      this.router.navigate(['dashboard']);
      holder = data;
    },
      error => this.message = error.message,
      () => this.reset()
    );
    return holder;
  }

  validateEamil(){
    this.validEmail = this.validation.validateEmail(this.profile.email);
  }

  reset() {
    this.profile = {} as Profile;
    this.message = "";
  }
}
