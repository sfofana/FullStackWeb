package com.sfofana.bank.bank.service;

import com.sfofana.bank.bank.model.AccountHolder;
import com.sfofana.bank.bank.repository.AccountHolderRepository;
import com.sfofana.bank.bank.repository.AccountRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import javax.mail.MessagingException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    AccountHolderRepository holderRepo;
    @Mock
    AccountRepository accountRepo;

    @InjectMocks
    UserService userService;

    @Test
    void register() throws IOException, MessagingException {
        AccountHolder holder = new AccountHolder();
        Throwable error = Assertions.catchThrowable(() -> {
            userService.register(holder);
        });
        assertEquals("Invalid request", error.getMessage());

        holder.setEmail("example@email.com");
        holder.setSsn(200000001);
        Mockito.when(holderRepo.findByEmail(holder.getEmail())).thenReturn(holder);
        AccountHolder result = userService.register(holder);
        assertEquals("example@email.com", result.getEmail());
    }

    @Test
    void logout() {
    }
}