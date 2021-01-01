package com.sfofana.bank.bank.controller;

import com.sfofana.bank.bank.model.AccountHolder;
import com.sfofana.bank.bank.model.lookup.MoneyFlow;
import com.sfofana.bank.bank.service.UserService;
import com.sfofana.bank.bank.transfer.Profile;
import com.sfofana.bank.bank.transfer.Transaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.io.IOException;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService service;

    @PostMapping("register")
    public AccountHolder register(@RequestBody AccountHolder holder) throws IOException, MessagingException {
        log.info("user hit /register endpoint");
        return service.register(holder);
    }

    @PostMapping("login")
    public AccountHolder login(@RequestBody Profile profile) {
        log.info("user hit /login endpoint");
        return service.login(profile);
    }

    @PostMapping("logout")
    public AccountHolder logout(@RequestBody Profile profile) {
        return service.logout(profile);
    }

    @PostMapping("apply")
    public AccountHolder applyForAccount(@RequestBody Transaction transaction) {
        return service.addAccount(transaction);
    }

    @PutMapping("edit")
    public AccountHolder editProfile(@RequestBody Profile profile) {
        return service.editProfile(profile);
    }

    @PutMapping("deposit")
    public AccountHolder deposit(@RequestBody Transaction transaction) {
        return service.processTransaction(transaction, MoneyFlow.DEPOSIT);
    }

    @PutMapping("withdraw")
    public AccountHolder withdraw(@RequestBody Transaction transaction) {
        return service.processTransaction(transaction, MoneyFlow.WITHDRAW);
    }

    @PutMapping("transfer")
    public AccountHolder transfer(@RequestBody Transaction transaction) {
        return service.processTransfer(transaction);
    }

}
