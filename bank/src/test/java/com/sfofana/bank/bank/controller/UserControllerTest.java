package com.sfofana.bank.bank.controller;

import com.sfofana.bank.bank.model.AccountHolder;
import com.sfofana.bank.bank.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.mail.MessagingException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Mock
    UserService service;

    @InjectMocks
    UserController controller;

    @Test
    void register() throws IOException, MessagingException {
        AccountHolder holder = new AccountHolder();
        holder.setId(1);
        holder.setEmail("admin@gmail.com");
        Mockito.when(service.register(holder)).thenReturn(holder);

        AccountHolder returnedHolder = controller.register(holder);

        assertEquals("admin@gmail.com", returnedHolder.getEmail());
    }

    @Test
    void login() {
    }
}