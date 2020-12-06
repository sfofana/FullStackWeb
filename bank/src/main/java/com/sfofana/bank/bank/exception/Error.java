package com.sfofana.bank.bank.exception;

public class Error {

    private String message;
    private String details;

    public Error() {
    }

    public Error(String message, String details) {
        this.message = message;
        this.details = details;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return this.details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

}
