package com.forexservice.service;


import com.forexservice.Repository.AccountRepository;
import com.forexservice.exception.NotFoundException;
import com.forexservice.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;



@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    public Account getAccountByAccountNumber(String accountNumber){
        return accountRepository.findByAccountNumber(accountNumber);
    }

    public Account addAccount(Account account){
        return accountRepository.save(account);
    }

    public void deleteAccount(String accountNumber){
        Account c=accountRepository.findByAccountNumber(accountNumber);
        accountRepository.deleteById(c.getAccountId());
    }

    public String updateAccount(int accountId,Account account){
        Optional<Account>account1=accountRepository.findById(accountId);
        if(account1.isPresent()) {
            Account account2=accountRepository.findById(accountId).get();
            account2.setAccountNumber(account.getAccountNumber());
            account2.setBankName(account.getBankName());
            account2.setIfscCode(account.getIfscCode());
            account2.setBalance(0.0);
            accountRepository.save(account2);
            return "Account successfully updated";
        }
        else {
            throw new NotFoundException("Account not Found");
        }
    }
}

