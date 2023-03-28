package com.revature.RevPayBackend.service;

import com.revature.RevPayBackend.entity.BankAccount;

public interface BankAccountService {

    BankAccount insert(BankAccount bankAccount);
    BankAccount getById(Long id);
    BankAccount update(BankAccount bankAccount);
    boolean delete(Long id);


}
