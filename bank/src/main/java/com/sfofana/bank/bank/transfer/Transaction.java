package com.sfofana.bank.bank.transfer;

public class Transaction {

    private Integer holderId;
    private Integer accountNumber;
    private String accountName;
    private Double amount;
    private boolean credit;
    private String transferAccount;
    private String receiverEmail;

    public Integer getHolderId() {
        return this.holderId;
    }

    public void setHolderId(Integer holderId) {
        this.holderId = holderId;
    }

    public Integer getAccountNumber() {
        return this.accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return this.accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Double getAmount() {
        return this.amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
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

    public String getTransferAccount() {
        return this.transferAccount;
    }

    public void setTransferAccount(String transferAccount) {
        this.transferAccount = transferAccount;
    }

    public String getReceiverEmail() {
        return this.receiverEmail;
    }

    public void setReceiverEmail(String receiverEmail) {
        this.receiverEmail = receiverEmail;
    }

}
