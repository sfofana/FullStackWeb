import { AccountHolder } from '../../models/account-holder';
import { UserService } from '../../services/user.service';
import { ValidationService } from '../../services/validation.service';
import { register } from 'ts-node';
import { Profile } from '../../models/profile';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  profile: Profile = {} as Profile;
  message: string;

  constructor(private service: UserService, private validation: ValidationService) { }

  ngOnInit(): void {
  }

  login() {
    this.service.login(this.profile).subscribe(
      data => console.log(data),
      error => this.message = error.message,
      () => this.reset()
    );
  }

  reset() {
    this.profile = {} as Profile;
    this.message = "";
  }
}
