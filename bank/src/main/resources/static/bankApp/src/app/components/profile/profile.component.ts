import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Profile } from 'src/app/models/profile';
import { SubjectService } from 'src/app/services/subject.service';
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
  edit: boolean = false;
  message: string;

  constructor(private service: UserService, private validation: ValidationService, private memory: SubjectService, private router: Router) { }

  ngOnInit(): void {
    this.memory.session.subscribe(
      data => {
        this.holder = data;
        this.profile.firstname = data.firstname;
        this.profile.lastname = data.lastname;
        this.profile.dob = data.dob;
        this.profile.address = data.address;
        this.profile.email = data.email;
        this.profile.password = data.password;
        this.profile.creditScore = data.creditScore;
      }
    );
  }

  getInfo() {
    this.profile.email = this.holder.email;
    this.profile.password = this.holder.password;
    this.service.login(this.profile).subscribe(
      data => this.memory.setSession(data),
      error => this.message = error.message
    );
  }

  toggle(mode: string) {
    switch (mode) {
      case "edit":
        this.edit = true;
        break;
      case "exit":
        this.edit = false;
        break;
    }
  }

  saveProfile(){
    this.service.editProfile(this.profile).subscribe(data => {
      this.holder = data;
      this.memory.setSession(data);
    });
  }

  cancelProfile(){
    this.getInfo();
  }

  reset() {
    this.profile = {} as Profile;
    this.message = "";
  }
}
