package com.revature.RevPayBackend.controller;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.RevPayBackend.entity.Transaction;
import com.revature.RevPayBackend.service.TransactionService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/transaction")

public class TransactionController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    TransactionService transactionService;

    @PostMapping()
    public ResponseEntity insert(@RequestBody Transaction transaction) {
        transactionService.insert(transaction);
        logger.info("Object made: " + transaction.toString());
        return ResponseEntity.status(201).build();
    };
//
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Transaction>> getAll() {

        logger.info("Success");
        return ResponseEntity.ok(transactionService.getAll());
    }

    @GetMapping("/{transactionIdentifier}")
    public ResponseEntity <Transaction> getByIdOrName(@PathVariable("transactionIdentifier") String identifier) {
        try {
            Long id = Long.parseLong(identifier);
            logger.info("Success");
            return ResponseEntity.ok(transactionService.getById(id));
        } catch(Exception e) {
            logger.error("Not Found");
            return ResponseEntity.status(404).build();

        }

    }
    @PutMapping()
    public ResponseEntity<Transaction> update(@RequestBody Transaction transaction) {
        try{
            transactionService.getById(transaction.getTransactionId());
            logger.info("Updated" + transaction.toString());
            return ResponseEntity.ok(transactionService.update(transaction));
        }
        catch(Exception e){
            logger.error("Not Found");
            return ResponseEntity.status(404).build();
        }

    }

    @DeleteMapping("/{transactionIdentifier}")
    public ResponseEntity<Boolean> delete(@PathVariable("transactionIdentifier") String identifier) {
//        return appUserService.delete(id);
        try {
            Long id = Long.parseLong(identifier);
            boolean response = transactionService.delete(id);
            ResponseEntity responseEntity = null;
            if (response){
                logger.info("Success");
                responseEntity = ResponseEntity.ok(true);
            }
            else{
                logger.error("Not Found: 404");
                responseEntity = ResponseEntity.status(404).build();
            }
            return responseEntity;
        } catch(Exception e) {
            logger.error("Not Found: 404");
            return ResponseEntity.status(404).build();
        }
    }
}