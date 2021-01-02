package com.sfofana.rest.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "firstname",
        "lastname",
        "dob",
        "address",
        "ssn",
        "loggedin",
        "activeDate",
        "creditScore",
        "email",
        "password",
        "accounts"
})
public class AccountHolder {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("firstname")
    private String firstname;
    @JsonProperty("lastname")
    private String lastname;
    @JsonProperty("dob")
    private String dob;
    @JsonProperty("address")
    private String address;
    @JsonProperty("ssn")
    private Integer ssn;
    @JsonProperty("loggedin")
    private Boolean loggedin;
    @JsonProperty("activeDate")
    private String activeDate;
    @JsonProperty("creditScore")
    private Integer creditScore;
    @JsonProperty("email")
    private String email;
    @JsonProperty("password")
    private String password;
    @JsonProperty("accounts")
    private List<Account> accounts = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("firstname")
    public String getFirstname() {
        return firstname;
    }

    @JsonProperty("firstname")
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @JsonProperty("lastname")
    public String getLastname() {
        return lastname;
    }

    @JsonProperty("lastname")
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @JsonProperty("dob")
    public String getDob() {
        return dob;
    }

    @JsonProperty("dob")
    public void setDob(String dob) {
        this.dob = dob;
    }

    @JsonProperty("address")
    public String getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(String address) {
        this.address = address;
    }

    @JsonProperty("ssn")
    public Integer getSsn() {
        return ssn;
    }

    @JsonProperty("ssn")
    public void setSsn(Integer ssn) {
        this.ssn = ssn;
    }

    @JsonProperty("loggedin")
    public Boolean getLoggedin() {
        return loggedin;
    }

    @JsonProperty("loggedin")
    public void setLoggedin(Boolean loggedin) {
        this.loggedin = loggedin;
    }

    @JsonProperty("activeDate")
    public String getActiveDate() {
        return activeDate;
    }

    @JsonProperty("activeDate")
    public void setActiveDate(String activeDate) {
        this.activeDate = activeDate;
    }

    @JsonProperty("creditScore")
    public Integer getCreditScore() {
        return creditScore;
    }

    @JsonProperty("creditScore")
    public void setCreditScore(Integer creditScore) {
        this.creditScore = creditScore;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("password")
    public String getPassword() {
        return password;
    }

    @JsonProperty("password")
    public void setPassword(String password) {
        this.password = password;
    }

    @JsonProperty("accounts")
    public List<Account> getAccounts() {
        return accounts;
    }

    @JsonProperty("accounts")
    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}