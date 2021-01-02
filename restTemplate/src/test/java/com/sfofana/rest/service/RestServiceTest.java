package com.sfofana.rest.service;

import com.sfofana.rest.model.AccountHolder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RestServiceTest {

    @Autowired
    RestService service;

    @BeforeEach
    void setUp() {
    }

    @Test
    void postRequest() {
        AccountHolder holder = new AccountHolder();
        holder.setEmail("master@gmail.com");
        holder.setPassword("demo");

        AccountHolder result = service.postRequest(holder);
        assertEquals("master@gmail.com", result.getEmail());
    }
}