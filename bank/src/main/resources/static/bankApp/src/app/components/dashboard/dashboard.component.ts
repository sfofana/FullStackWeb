import { AccountHolder } from '../../models/account-holder';
import { Account } from '../../models/account';
import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { ValidationService } from 'src/app/services/validation.service';
import { SubjectService } from 'src/app/services/subject.service';
import { Profile } from '../../models/profile';
import { Transaction } from '../../models/transaction';
import { Router } from '@angular/router';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  holder: AccountHolder = {} as AccountHolder;
  profile: Profile = {} as Profile;
  transaction: Transaction = {} as Transaction;
  creditAccounts: Account[] = [];
  bankkingAccounts: Account[] = [];
  deposit: boolean;
  withdraw: boolean;
  transfer: boolean;
  apply: boolean;
  message: string;

  constructor(private service: UserService, private validation: ValidationService, private memory: SubjectService, private router: Router) { }

  ngOnInit(): void {
    this.toggle('deposit');
    this.memory.session.subscribe(
      data => {
        this.holder = data;
        if (data.accounts)
          data.accounts.forEach(account => {
            if (account.credit)
              this.creditAccounts.push(account);
            else
              this.bankkingAccounts.push(account);
          });
      },
      error => this.message = error.error.message
    );
  }

  getInfo() {
    this.profile.email = this.holder.email;
    this.profile.password = this.holder.password;
    this.service.login(this.profile).subscribe(
      data => {
        this.holder = data;
        this.memory.setSession(data);
      },
      error => this.message = error.message,
      () => this.reset()
    );
  }

  toggle(tab: string) {
    console.log(tab)
    switch (tab) {
      case "deposit":
        this.deposit = true;
        this.withdraw = false;
        this.transfer = false;
        this.apply = false;
        break;
      case "withdraw":
        this.deposit = false;
        this.withdraw = true;
        this.transfer = false;
        this.apply = false;
        break;
      case "transfer":
        this.deposit = false;
        this.withdraw = false;
        this.transfer = true;
        this.apply = false;
        break;
      case "apply":
        this.deposit = false;
        this.withdraw = false;
        this.transfer = false;
        this.apply = true;
        break;
    }
  }

  selectTransaction(name: string) {
    this.transaction.holderId = this.holder.id;
    this.transaction.accountName = name;
  }

  selectTransfer(transferName: string, receiverEmail: string) {
    this.transaction.transferAccount = transferName;
    this.transaction.receiverEmail = receiverEmail;
  }

  depositMoney() {
    this.service.deposit(this.transaction).subscribe(
      data => this.memory.setSession(data)
    )
    this.reset();
  }

  withdrawMoney() {
    this.service.withdraw(this.transaction).subscribe(
      data => this.memory.setSession(data)
    )
    this.reset();
  }

  transferMoney() {
    this.service.transfer(this.transaction).subscribe(
      data => this.memory.setSession(data)
    )
    this.reset();
  }

  applyForAccount() {
    this.transaction.holderId = this.holder.id;
    this.service.applyForAccount(this.transaction).subscribe(
      data => this.memory.setSession(data)
    )
    this.reset();
  }

  reset() {
    this.profile = {} as Profile;
    this.bankkingAccounts = [];
    this.creditAccounts = [];
    this.transaction = {} as Transaction;
    this.message = "";
  }
}
