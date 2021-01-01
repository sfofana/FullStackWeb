import { HttpClientTestingModule } from '@angular/common/http/testing';
import { TestBed } from '@angular/core/testing';

import { ValidationService } from './validation.service';
import { UserService } from './user.service';
import { SubjectService } from './subject.service';

describe('ValidationService', () => {
  let service: ValidationService;

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
    service = TestBed.inject(ValidationService);
  });

  it('should be created', () => {
    console.log("in test");
    expect(service).toBeTruthy();
  });
});
