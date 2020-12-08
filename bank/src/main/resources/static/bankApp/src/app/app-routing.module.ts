import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { HomeComponent } from './components/home/home.component';
import { LogoutComponent } from './components/logout/logout.component';
import { ProfileComponent } from './components/profile/profile.component';
import { RegisterComponent } from './components/register/register.component';


const routes: Routes = [
  {path: "home", component: HomeComponent},
  {path: "dashboard", component: DashboardComponent},
  {path: "register", component: RegisterComponent},
  {path: "profile", component: ProfileComponent},
  {path: "logout", component: LogoutComponent},
  {path: "**", pathMatch: "full", redirectTo: "home"},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
