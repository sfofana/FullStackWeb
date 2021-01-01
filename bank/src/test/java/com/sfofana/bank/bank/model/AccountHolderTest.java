package com.sfofana.bank.bank.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountHolderTest {

    @Test
    void getId() {
        AccountHolder holder = new AccountHolder();
        holder.setId(24);
        assertEquals(24, holder.getId());
    }

    @Test
    void setId() {
    }
}