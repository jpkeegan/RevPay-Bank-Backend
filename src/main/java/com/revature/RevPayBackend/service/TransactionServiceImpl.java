package com.revature.RevPayBackend.service;


import com.revature.RevPayBackend.repository.TransactionRepository;
import com.revature.RevPayBackend.entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class TransactionServiceImpl implements TransactionService{

    @Autowired
    TransactionRepository transactionRepository;


    @Override
    public Transaction insert(Transaction transaction) {return transactionRepository.save(transaction);}

    @Override
    public Transaction getById(Long id) {return transactionRepository.findById(id).get();}

    @Override
    public List<Transaction> getAll() {return transactionRepository.findAll();}

    @Override
    public Transaction update(Transaction transaction){return transactionRepository.save(transaction);}
    //@Override
    //public AppUser loginWithBody(AppUser appUser){return appUserRepository.login(appUser);}
    @Override
    public boolean delete(Long id) {
        boolean found = transactionRepository.existsById(id);
        if(found) transactionRepository.deleteById(id);
        return found;
    }

//    @Override
//    public List<AppUser> getAll(String flag) {
//        System.out.println(flag);
//        // this overloaded method takes in a flag and calls the corresponding Repository method:
//        switch(flag) {
//            case "cats":
//                //return employeeRepository.findAll();
//            default:
//                return employeeRepository.findAll();
//        }
//    }


//    public List<AppUser> findByUsername(String username) {return appUserRepository.findByUsername(username);}

}