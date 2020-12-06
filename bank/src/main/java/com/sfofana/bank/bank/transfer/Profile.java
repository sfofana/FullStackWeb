package com.sfofana.bank.bank.transfer;

public class Profile {

    private String firstname;
    private String lastname;
    private String dob;
    private String address;
    private boolean loggedin;
    private String email;
    private String password;

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

    public boolean isLoggedin() {
        return this.loggedin;
    }

    public boolean getLoggedin() {
        return this.loggedin;
    }

    public void setLoggedin(boolean loggedin) {
        this.loggedin = loggedin;
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

}
