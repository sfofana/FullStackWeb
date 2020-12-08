import { register } from 'ts-node';
import { AccountHolder } from '../models/account-holder';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';
import { Profile } from '../models/profile';
import { Transaction } from '../models/transaction';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  public register(holder: AccountHolder): Observable<AccountHolder> {
    return this.http.post<AccountHolder>(`${environment.baseUrl}/${environment.registerUrl}`, holder);
  }

  public login(profile: Profile): Observable<AccountHolder> {
    return this.http.post<AccountHolder>(`${environment.baseUrl}/${environment.loginUrl}`, profile);
  }

  public applyForAccount(transaction: Transaction): Observable<AccountHolder> {
    return this.http.post<AccountHolder>(`${environment.baseUrl}/${environment.applyUrl}`, transaction);
  }

  public editProfile(profile: Profile): Observable<AccountHolder> {
    return this.http.put<AccountHolder>(`${environment.baseUrl}/${environment.editUrl}`, profile);
  }

  public deposit(transaction: Transaction): Observable<AccountHolder> {
    return this.http.put<AccountHolder>(`${environment.baseUrl}/${environment.depositUrl}`, transaction);
  }

  public withdraw(transaction: Transaction): Observable<AccountHolder> {
    return this.http.put<AccountHolder>(`${environment.baseUrl}/${environment.withdrawUrl}`, transaction);
  }

  public transfer(transaction: Transaction): Observable<AccountHolder> {
    return this.http.put<AccountHolder>(`${environment.baseUrl}/${environment.transferUrl}`, transaction);
  }
}
