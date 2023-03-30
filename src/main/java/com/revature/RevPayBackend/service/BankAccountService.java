package com.revature.RevPayBackend.service;

import com.revature.RevPayBackend.entity.BankAccount;
import com.revature.RevPayBackend.exceptions.UserExceptions.IdNotFoundException;

import java.util.List;

public interface BankAccountService {

    BankAccount insert(BankAccount bankAccount);
    BankAccount getById(Long bankAccountId) throws IdNotFoundException;
    List<BankAccount> getAll();
    BankAccount update(BankAccount bankAccount) throws IdNotFoundException;
    boolean delete(Long bankAccountId) throws IdNotFoundException;


}
