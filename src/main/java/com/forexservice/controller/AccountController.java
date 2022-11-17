package com.forexservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.forexservice.model.Account;
import com.forexservice.model.Currency;
import com.forexservice.service.AccountService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping("/get/{accountNumber}")
    public Account getAccountDetails(@PathVariable String accountNumber){
        return accountService.getAccountByAccountNumber(accountNumber);
    }

    @PostMapping("/create")
    public Account addAccount(@RequestBody Account account){
        return accountService.addAccount(account);
    }

    @PutMapping("/update/{accountId}")
    public  void updateCurrency(@RequestBody Account account,@PathVariable int accountId){
        accountService.updateAccount(accountId,account);
    }

    @DeleteMapping("/remove/{accountNumber}")
    public void deleteCurrency(@PathVariable String accountNumber){
        accountService.deleteAccount(accountNumber);
    }
}
