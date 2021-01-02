package com.sfofana.rest.service;

import com.sfofana.rest.model.AccountHolder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class RestServiceMockTest {

    @Mock
    RestTemplate restTemplate;

    @InjectMocks
    RestService service;

    AccountHolder holder = new AccountHolder();

    @BeforeEach
    void setUp() {
        holder.setEmail("example@email.com");
        holder.setPassword("password");
        service.loginUrl = "http://localhost:9000/api/v1/login";
    }

    @Test
    void postRequest() {
        AccountHolder holder = new AccountHolder();
        holder.setEmail("master@gmail.com");
        holder.setPassword("demo");
        Mockito.when(restTemplate.postForObject(service.loginUrl, holder, AccountHolder.class))
                .thenReturn(holder);
        AccountHolder result = service.postRequest(holder);
        assertEquals("master@gmail.com", result.getEmail());
    }
}