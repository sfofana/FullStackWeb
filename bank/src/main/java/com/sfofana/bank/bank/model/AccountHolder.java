package com.sfofana.bank.bank.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class AccountHolder {

    @Id
    private Integer id;
    private String firstname;
    private String lastname;
    private String dob;
    private String address;
    private Integer ssn;
    private boolean loggedin;
    private String activeDate;
    private String email;
    private String password;
    @OneToMany
    private List<Account> accounts;

    public AccountHolder() {
    }

    public AccountHolder(Integer id, String firstname, String lastname, String dob, String address, Integer ssn,
            boolean loggedin, String activeDate, String email, String password, List<Account> accounts) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dob = dob;
        this.address = address;
        this.ssn = ssn;
        this.loggedin = loggedin;
        this.activeDate = activeDate;
        this.email = email;
        this.password = password;
        this.accounts = accounts;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDob() {
        return this.dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getSsn() {
        return this.ssn;
    }

    public void setSsn(Integer ssn) {
        this.ssn = ssn;
    }

    public boolean isLoggedin() {
        return this.loggedin;
    }

    public boolean getLoggedin() {
        return this.loggedin;
    }

    public void setLoggedin(boolean loggedin) {
        this.loggedin = loggedin;
    }

    public String getActiveDate() {
        return this.activeDate;
    }

    public void setActiveDate(String activeDate) {
        this.activeDate = activeDate;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Account> getAccounts() {
        return this.accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

}
