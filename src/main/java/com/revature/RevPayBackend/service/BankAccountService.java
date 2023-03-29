package com.revature.RevPayBackend.service;

import com.revature.RevPayBackend.entity.BankAccount;
import com.revature.RevPayBackend.exceptions.UserExceptions.IdNotFoundException;

public interface BankAccountService {

    BankAccount insert(BankAccount bankAccount);
    BankAccount getById(Long bankAccountId) throws IdNotFoundException;
    BankAccount update(BankAccount bankAccount) throws IdNotFoundException;
    boolean delete(Long bankAccountId) throws IdNotFoundException;


}
