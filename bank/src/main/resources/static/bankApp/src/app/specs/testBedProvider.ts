import { HttpClientModule } from '@angular/common/http';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { Type } from '@angular/core';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from 'src/app/app-routing.module';
import { SubjectService } from 'src/app/services/subject.service';
import { UserService } from 'src/app/services/user.service';
import { ValidationService } from 'src/app/services/validation.service';
import { AppComponent } from '../app.component';
import { DashboardComponent } from '../components/dashboard/dashboard.component';
import { HomeComponent } from '../components/home/home.component';
import { LogoutComponent } from '../components/logout/logout.component';
import { ProfileComponent } from '../components/profile/profile.component';
import { RegisterComponent } from '../components/register/register.component';


export class TestBedProvider {

  public fixtureBuilder<T>(component: Type<T>): ComponentFixture<T> {
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
        { provide: UserService, useClass: UserServiceStub },
        ValidationService,
        SubjectService,
      ]
    }).compileComponents();
    const fixture = TestBed.createComponent(component);
    return fixture;
  }

  public errorFixtureBuilder<T>(component: Type<T>): ComponentFixture<T> {
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
        { provide: UserService, useClass: UserServiceErrorStub },
        ValidationService,
        SubjectService,
      ]
    }).compileComponents();
    const fixture = TestBed.createComponent(component);
    return fixture;
  }

  public serviceTestBed<T>(service: Type<T>): T {
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
    const bed: T = TestBed.get(service)
    return bed;
  }

}

class UserServiceStub {

  // public getAccess(user: User): Observable<User> {
  //   return of({
  //     role: "spec",
  //     cToken: "cToken",
  //     jToken: "jToken"
  //   });
  // }

  // public sendEmail(message: FormData): Observable<Email>{
  //   return of({
  //     name: "spec",
  //     email: "email",
  //     phone: "num",
  //     subject: "subj",
  //     message: "stub"
  //   });
  // }

  // public upload(fileName: string, file: FormData): Observable<Upload>{
  //   return of({
  //     name: "spec",
  //     process: "success",
  //     image: "image"
  //   });
  // }

  // public compareFaces(faces: Compare) : Observable<Compare> {
  //   return of({
  //     names: ["spec","test"],
  //     images: ["image1","image2"],
  //     details: ["detail1","detail2"],
  //     results: 50
  //   });
  // }
}

class UserServiceErrorStub {

  // public getAccess(user: User): Observable<User> {
  //   return throwError("Method not implemented.");
  // }

  // public sendEmail(message: FormData): Observable<Email>{
  //   return throwError("Method not implemented.");
  // }

  // public upload(fileName: string, file: FormData): Observable<Upload>{
  //   return throwError("Method not implemented.");
  // }

  // public compareFaces(faces: Compare) : Observable<Compare> {
  //   return throwError("Method not implemented.");
  // }
}


