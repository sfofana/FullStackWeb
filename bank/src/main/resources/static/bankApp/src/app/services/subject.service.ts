import { BehaviorSubject, Subject } from 'rxjs';
import { Injectable } from '@angular/core';
import { AccountHolder } from '../models/account-holder';

@Injectable({
  providedIn: 'root'
})
export class SubjectService {

  blankHolder: AccountHolder = {} as AccountHolder

  public unsunscribe = new Subject();

  private behavior = new BehaviorSubject<AccountHolder>(this.blankHolder);

  public setSession(holder: AccountHolder) {
    console.dir(holder)
    this.behavior.next(holder);
  }

  public session = this.behavior.asObservable();
}
