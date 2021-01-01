import { HttpClientTestingModule } from '@angular/common/http/testing';
import { TestBed } from '@angular/core/testing';

import { UserService } from './user.service';
import { ValidationService } from './validation.service';
import { SubjectService } from './subject.service';
import { Profile } from '../models/profile';

describe('UserService', () => {
  let service: UserService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [
        HttpClientTestingModule
      ],
      providers: [
        UserService,
        ValidationService,
        SubjectService,
      ]
    });
    service = TestBed.inject(UserService);
  });

  it('should login', () => {
    let profile: Profile = {
      firstname: "string",
      lastname: "string",
      dob: "string",
      address: "string",
      loggedin: true,
      creditScore: 121455,
      email: "string",
      password: "string",
    } as Profile;
    service.login(profile);
    expect(service).toBeTruthy();
  });
});
