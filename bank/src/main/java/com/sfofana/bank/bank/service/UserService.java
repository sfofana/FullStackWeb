package com.sfofana.bank.bank.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.sfofana.bank.bank.exception.BusinessException;
import com.sfofana.bank.bank.model.Account;
import com.sfofana.bank.bank.model.AccountHolder;
import com.sfofana.bank.bank.repository.AccountHolderRepository;
import com.sfofana.bank.bank.repository.AccountRepository;
import com.sfofana.bank.bank.transfer.Profile;
import com.sfofana.bank.bank.transfer.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public static final String Checking = "checking";
    public static final String Saving = "saving";
    public static final String Deposit = "Deposit";
    public static final String Withdraw = "Withdraw";


    @Autowired
    AccountHolderRepository holderRepo;
    @Autowired
    AccountRepository accountRepo;

    public AccountHolder register(AccountHolder holder) throws BusinessException {
        if (holder.getEmail() == null || holder.getSsn() < 100000000) {
            throw new BusinessException("Invalid request");
        }

        AccountHolder newHolder = holderRepo.save(holder);
        Account checking = new Account(null, Checking, false, 0.0, newHolder);
        Account saving = new Account(null, Saving, false, 0.0, newHolder);
        List<Account> defaultAccounts = List.of(checking, saving);
        accountRepo.saveAll(defaultAccounts);

        return holderRepo.findByEmail(holder.getEmail());
    }

    public AccountHolder addAccount(Transaction transaction) throws BusinessException {
        AccountHolder holder = holderRepo.getOne(transaction.getHolderId());
        Account newAccount = new Account(null, transaction.getAccountName(), false, 0.0, holder);
        if (transaction.getCredit()) {
            if (creditCheck() < 600) {
                throw new BusinessException("Rejected: credit score is too low");
            }
            newAccount.setCredit(transaction.getCredit());
        }
        accountRepo.save(newAccount);
        return holderRepo.getOne(transaction.getHolderId());
    }

    public AccountHolder login(Profile profile) throws BusinessException {
        AccountHolder holder = holderRepo.findByEmail(profile.getEmail());

        if (holder == null) {
            throw new BusinessException("No accounts found with email");
        } else if (!holder.getPassword().equals(profile.getPassword())) {
            throw new BusinessException("Invalid credentials");
        }

        return holder;
    }

    public AccountHolder editProfile(Profile profile) {
        AccountHolder holder = holderRepo.findByEmail(profile.getEmail());
        holder.setAddress(profile.getAddress());
        holder.setDob(profile.getDob());
        holder.setFirstname(profile.getFirstname());
        holder.setLastname(profile.getLastname());
        holder.setEmail(profile.getEmail());
        holder.setPassword(profile.getPassword());
        return holderRepo.save(holder);
    }

    public AccountHolder processTransaction(Transaction transaction, String type) {
        AccountHolder holder = holderRepo.getOne(transaction.getHolderId());
        List<Account> accounts = new ArrayList<>();

        switch (type) {
            case "Deposit":
                holder.getAccounts().stream().forEach(account -> {
                    if (account.getName().equals(transaction.getAccountName())) {
                        double amount = account.getBalance() + transaction.getAmount();
                        account.setBalance(amount);
                    }
                    accounts.add(account);
                });
                break;
            case "Withdraw":
                holder.getAccounts().stream().forEach(account -> {
                    if (account.getName().equals(transaction.getAccountName())) {
                        double amount = account.getBalance() - transaction.getAmount();
                        account.setBalance(amount);
                    }
                    accounts.add(account);
                });
                break;
        }

        accountRepo.saveAll(accounts);
        return holderRepo.getOne(transaction.getHolderId());
    }

    public AccountHolder processTransfer(Transaction transaction){
        AccountHolder holder = processTransaction(transaction, UserService.Withdraw);

        AccountHolder reciever = holderRepo.findByEmail(transaction.getReceiverEmail());
        List<Account> accounts = new ArrayList<>();
        reciever.getAccounts().stream().forEach(account -> {
            if (account.getName().equals(transaction.getAccountName())) {
                double amount = account.getBalance() + transaction.getAmount();
                account.setBalance(amount);
            }
            accounts.add(account);
        });
        accountRepo.saveAll(accounts);
        return holder;
    }

    private int creditCheck() {
        Random random = new Random();
        int upperbound = 800;
        return random.nextInt(upperbound);
    }
}
