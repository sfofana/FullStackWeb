package com.sfofana.bank.bank.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Account {

    @Id
    private Integer number;
    private String name;
    private boolean credit;
    private Double balance;
    @ManyToOne
    private AccountHolder holder;

    public Account() {
    }

    public Account(Integer number, String name, boolean credit, Double balance, AccountHolder holder) {
        this.number = number;
        this.name = name;
        this.credit = credit;
        this.balance = balance;
        this.holder = holder;
    }

    public Integer getNumber() {
        return this.number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCredit() {
        return this.credit;
    }

    public boolean getCredit() {
        return this.credit;
    }

    public void setCredit(boolean credit) {
        this.credit = credit;
    }

    public Double getBalance() {
        return this.balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public AccountHolder getHolder() {
        return this.holder;
    }

    public void setHolder(AccountHolder holder) {
        this.holder = holder;
    }

}
