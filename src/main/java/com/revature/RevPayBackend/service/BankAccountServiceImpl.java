package com.revature.RevPayBackend.service;

import com.revature.RevPayBackend.entity.BankAccount;
import com.revature.RevPayBackend.exceptions.UserExceptions.IdNotFoundException;
import com.revature.RevPayBackend.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.persistence.Id;

@Service
@Primary
public class BankAccountServiceImpl implements BankAccountService {

    @Autowired
    BankAccountRepository bankAccountRepository;

    @Override
    public BankAccount insert(BankAccount bankAccount) {
        return bankAccountRepository.save(bankAccount);
    }

    @Override
    public BankAccount getById(Long bankAccountId) {
        return bankAccountRepository.findById(bankAccountId).get();
    }

    @Override
    public BankAccount update(BankAccount bankAccount) {
        return bankAccountRepository.save(bankAccount);
    }

    @Override
    public boolean delete(Long bankAccountId)  {
        boolean found = bankAccountRepository.existsById(bankAccountId);
        if(found) bankAccountRepository.deleteById(bankAccountId);
        return found;
    }
}
