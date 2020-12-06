package com.sfofana.bank.bank.repository;

import com.sfofana.bank.bank.model.AccountHolder;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountHolderRepository extends JpaRepository<AccountHolder, Integer> {
    
    public AccountHolder findByEmail(String email);
}
