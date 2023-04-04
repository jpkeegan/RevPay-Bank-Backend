package com.revature.RevPayBackend.controller;

import com.revature.RevPayBackend.dto.BankAccountInput;
import com.revature.RevPayBackend.dto.Origin;
import com.revature.RevPayBackend.entity.BankAccount;
import com.revature.RevPayBackend.exceptions.UserExceptions.IdNotFoundException;
import com.revature.RevPayBackend.service.BankAccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = Origin.origin)
@RequestMapping("/bankAccounts")

public class BankAccountController {

    @Autowired
    BankAccountService bankAccountService;

    Logger logger1 = LoggerFactory.getLogger(BankAccountController.class);

    @PostMapping()
    public ResponseEntity <BankAccount> insert(@RequestBody BankAccountInput bankAccountInput) {
        logger1.info("Inserting bank account: {}", bankAccountInput);
        BankAccount bankAccount = new BankAccount(bankAccountInput);
        return new ResponseEntity<>(bankAccountService.insert(bankAccount), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity <BankAccount> getById(@PathVariable("id") Long id) throws IdNotFoundException {
            logger1.info("Getting bank account by ID: {}", id);
            return new ResponseEntity<>(bankAccountService.getById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity <List<BankAccount>> getAll() {
        List<BankAccount> bankAccounts;
        bankAccounts = bankAccountService.getAll();
        logger1.info("Getting all bank accounts: {}", bankAccounts.size());
        for (BankAccount bankAccount: bankAccounts) {
            logger1.info("BankAccounts: {}", bankAccount);
        }
        return new ResponseEntity<>(bankAccountService.getAll(), HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity <BankAccount> update(@RequestBody BankAccount bankAccount) throws IdNotFoundException {
            logger1.info("Updating bank account by id to: {}", bankAccount);
            return new ResponseEntity<>(bankAccountService.update(bankAccount), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Boolean> delete(@PathVariable("id") Long id) throws IdNotFoundException {
        logger1.info("Deleting the bank account with id {}", id);
        return new ResponseEntity<>(bankAccountService.delete(id), HttpStatus.OK);
    }

}
