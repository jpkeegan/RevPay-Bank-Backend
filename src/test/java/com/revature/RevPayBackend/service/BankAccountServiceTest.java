package com.revature.RevPayBackend.service;

import com.revature.RevPayBackend.entity.BankAccount;
import com.revature.RevPayBackend.exceptions.UserExceptions.IdNotFoundException;
import com.revature.RevPayBackend.repository.BankAccountRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

@SpringBootTest
public class BankAccountServiceTest {

    @MockBean(BankAccountRepository.class)
    BankAccountRepository bankAccountRepository;

    @Autowired
    BankAccountService bankAccountService;

    @Test
    public void testInsert(){
        BankAccount bankAccount = new BankAccount(111111111L, 22222222L, 1L);
        BankAccount expectedBankAccount = new BankAccount(1L, 111111111L, 22222222L, 1L, 2500.50);
        Mockito.when(bankAccountRepository.save(bankAccount)).thenReturn(expectedBankAccount);
        Assertions.assertEquals(expectedBankAccount, bankAccountService.insert(bankAccount));
    }

    @Test
    public void testGetById() throws IdNotFoundException {
        BankAccount expectedBankAccount = new BankAccount(1L, 111111111L, 22222222L, 1L, 2500.50);
        Mockito.when(bankAccountRepository.findById(1L)).thenReturn(Optional.of(expectedBankAccount));
        Assertions.assertEquals(expectedBankAccount, bankAccountService.getById(1L));

    }

    @Test
    public void testUpdate() throws IdNotFoundException{
        BankAccount bankAccount = new BankAccount(111111111L, 22222222L, 1L);
        BankAccount updatedBankAccount = new BankAccount(1L, 111111111L, 22222222L, 1L, 5000.25);
        Mockito.when(bankAccountRepository.save(bankAccount)).thenReturn(updatedBankAccount);
        Assertions.assertEquals(updatedBankAccount, bankAccountService.update(bankAccount));
    }

    @Test
    public void testDelete() throws IdNotFoundException{
        BankAccount bankAccount = new BankAccount(1L, 111111111L, 22222222L, 1L, 2500.50);
        Mockito.when(bankAccountRepository.existsById(1L)).thenReturn(true);
        Assertions.assertTrue(bankAccountService.delete(1L));
    }

}
