import { Component, OnInit } from '@angular/core';
import { Profile } from 'src/app/models/profile';
import { UserService } from 'src/app/services/user.service';
import { ValidationService } from 'src/app/services/validation.service';
import { AccountHolder } from '../../models/account-holder';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  
  holder: AccountHolder = {} as AccountHolder;
  profile: Profile = {} as Profile;
  message: string;

  constructor(private service: UserService, private validation: ValidationService) { }

  ngOnInit(): void {
    this.getInfo();
  }

  getInfo() {
    this.profile.email = "master@gmail.com";
    this.profile.password = "demo";
    this.service.login(this.profile).subscribe(
      data => this.holder = data,
      error => this.message = error.message,
      () => this.reset()
    );
  }

  reset() {
    this.profile = {} as Profile;
    this.message = "";
  }
}
