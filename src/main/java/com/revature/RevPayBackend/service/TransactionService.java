package com.revature.RevPayBackend.service;

import java.util.List;

import com.revature.RevPayBackend.entity.Transaction;


public interface TransactionService {
    Transaction insert(Transaction transaction);
    Transaction getById(Long id);
    List<Transaction> getAll();
    Transaction update(Transaction transaction);
    boolean delete(Long id);



}