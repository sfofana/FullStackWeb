import { HttpClientModule } from '@angular/common/http';
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { Observable, of } from 'rxjs';
import { AppRoutingModule } from 'src/app/app-routing.module';
import { AppComponent } from 'src/app/app.component';
import { AccountHolder } from 'src/app/models/account-holder';
import { Profile } from 'src/app/models/profile';
import { Transaction } from 'src/app/models/transaction';
import { SubjectService } from 'src/app/services/subject.service';
import { UserService } from 'src/app/services/user.service';
import { ValidationService } from 'src/app/services/validation.service';
import { environment } from 'src/environments/environment';
import { DashboardComponent } from '../dashboard/dashboard.component';
import { LogoutComponent } from '../logout/logout.component';
import { ProfileComponent } from '../profile/profile.component';
import { RegisterComponent } from '../register/register.component';

import { HomeComponent } from './home.component';

describe('HomeComponent', () => {
  let component: HomeComponent;
  let fixture: ComponentFixture<HomeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [
        AppComponent,
        HomeComponent,
        ProfileComponent,
        DashboardComponent,
        RegisterComponent,
        LogoutComponent,
      ],
      imports: [
        BrowserModule,
        AppRoutingModule,
        FormsModule,
        HttpClientModule
      ],
      providers: [
        {provide: UserService, useClass: UserSeviceStub},
        ValidationService,
        SubjectService
      ],
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be 10', () => {
    let holder:AccountHolder = component.login();
    let num = 10;

    expect("test@email.com").toBe(holder.email);
    expect(num).toBe(10);
  });
});

class UserSeviceStub {

  mockHolder: AccountHolder = {
    id: 1,
    firstname: "string",
    lastname: "string",
    dob: "string",
    address: "string",
    ssn: 1000000000,
    loggedin: true,
    activeDate: "string",
    creditScore: 654,
    email: "test@email.com",
    password: "string",
    accounts: []
  } as AccountHolder;

  public register(holder: AccountHolder): Observable<AccountHolder> {
    return of(this.mockHolder);
  }

  public login(profile: Profile): Observable<AccountHolder> {
    return of(this.mockHolder);
  }

  public logout(profile: Profile): Observable<AccountHolder> {
    return of(this.mockHolder);
  }

  public applyForAccount(transaction: Transaction): Observable<AccountHolder> {
    return of(this.mockHolder);
  }

  public editProfile(profile: Profile): Observable<AccountHolder> {
    return of(this.mockHolder);
  }

  public deposit(transaction: Transaction): Observable<AccountHolder> {
    return of(this.mockHolder);
  }

  public withdraw(transaction: Transaction): Observable<AccountHolder> {
    return of(this.mockHolder);
  }

  public transfer(transaction: Transaction): Observable<AccountHolder> {
    return of(this.mockHolder);
  }
}
