package com.forexservice.servicetests;


import com.forexservice.Repository.AccountRepository;
import com.forexservice.exception.NotFoundException;
import com.forexservice.model.Account;
import com.forexservice.service.AccountService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(SpringExtension.class)
public class AccountServiceTest {



    @InjectMocks
    AccountService accountService;

    @Mock
    AccountRepository accountRepository;

    @Test
    public void getAccountByAccountNumberTest()
    {
        Account account=new Account(1, "093563462351", "TestBank", "TEST001", 200.0);
        Mockito.when(accountRepository.findByAccountNumber("093563462351")).thenReturn(account);
        Account account1=accountService.getAccountByAccountNumber("093563462351");
        assertEquals(account, account1);
    }
    @Test
    public void addAccountTest()
    {
        Account account=new Account(1, "093563462351", "TestBank", "TEST001", 200.0);
        Mockito.when(accountRepository.save(account)).thenReturn(account);
        Account account1=accountService.addAccount(account);
        assertEquals(account, account1);
    }

    @Test
    public void updateAccountTest() throws NotFoundException
    {
        Account account=new Account(1, "093563462351", "TestBank", "TEST001", 200.0);
        Integer accountId=1;
        Mockito.when(accountRepository.findById(accountId)).thenReturn(Optional.of(account));
        String result=accountService.updateAccount(accountId, account);
        assertEquals("Account successfully updated", result);
    }
}