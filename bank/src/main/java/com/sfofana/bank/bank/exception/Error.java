package com.sfofana.bank.bank.exception;

import java.util.Date;

public class Error {

    private String message;
    private Date timestamp;

    public Error() {
    }

    public Error(String message, Date timestamp) {
        this.message = message;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

}
