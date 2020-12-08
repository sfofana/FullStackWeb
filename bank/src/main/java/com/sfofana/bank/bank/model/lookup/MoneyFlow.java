package com.sfofana.bank.bank.model.lookup;

public enum MoneyFlow {
    CHECKING("checking"), SAVING("saving"), DEPOSIT("deposit"), WITHDRAW("withdraw");

    private String description;

    MoneyFlow(String description) {
        this.description = description;
    }

    public String fromDescription() {
        return this.description;
    }
}
