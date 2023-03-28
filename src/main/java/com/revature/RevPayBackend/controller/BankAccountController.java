package com.revature.RevPayBackend.controller;

import com.revature.RevPayBackend.entity.BankAccount;
import com.revature.RevPayBackend.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class BankAccountController {

    @Autowired
    BankAccountService bankAccountService;

    @PostMapping()
    public ResponseEntity <BankAccount> insert(@RequestBody BankAccount bankAccount) {
        return new ResponseEntity<>(bankAccountService.insert(bankAccount), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity <BankAccount> getById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(bankAccountService.getById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity <BankAccount> update(@RequestBody BankAccount bankAccount) {
        return new ResponseEntity<>(bankAccountService.update(bankAccount), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Boolean> delete(@PathVariable("id") Long id) {
        return new ResponseEntity<>(bankAccountService.delete(id), HttpStatus.OK);
    }

}
