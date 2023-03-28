package com.revature.RevPayBackend.controller;

import com.revature.RevPayBackend.entity.BankAccount;
import com.revature.RevPayBackend.service.BankAccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/bankAccount")

public class BankAccountController {

    @Autowired
    BankAccountService bankAccountService;

    Logger logger1 = LoggerFactory.getLogger(BankAccountController.class);

    @PostMapping()
    public ResponseEntity <BankAccount> insert(@RequestBody BankAccount bankAccount) {
        logger1.info("Inserting bank account: {}", bankAccount);
        return new ResponseEntity<>(bankAccountService.insert(bankAccount), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity <BankAccount> getById(@PathVariable("id") Long id) {
        try {
            logger1.info("Getting bank account by ID: {}", id);
            return new ResponseEntity<>(bankAccountService.getById(id), HttpStatus.OK);
        } catch (Exception e) {
            logger1.info("Failed to get bank account by ID: {}", id);
            return new ResponseEntity<>(new BankAccount(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity <BankAccount> update(@RequestBody BankAccount bankAccount) {
        try {
            logger1.info("Updating bank account by id to: {}", bankAccount);
            return new ResponseEntity<>(bankAccountService.update(bankAccount), HttpStatus.OK);
        } catch (Exception e) {
            logger1.info("Failed to update bank account by ID");
            return new ResponseEntity<>(new BankAccount(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Boolean> delete(@PathVariable("id") Long id) {
        logger1.info("Deleting the bank account with id {}", id);
        return new ResponseEntity<>(bankAccountService.delete(id), HttpStatus.OK);
    }

}
