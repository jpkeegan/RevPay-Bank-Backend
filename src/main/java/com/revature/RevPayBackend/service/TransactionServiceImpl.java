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

//
//    @Override
//    public AppUser insert(AppUser appUser) {return appUserRepository.save(appUser);}
//
//    @Override
//    public AppUser getById(Long id) {return appUserRepository.findById(id).get();}
//
//    @Override
//    public List<AppUser> getAll() {return appUserRepository.findAll();}
//
//    @Override
//    public AppUser update(AppUser appUser){return appUserRepository.save(appUser);}
//    //@Override
//    //public AppUser loginWithBody(AppUser appUser){return appUserRepository.login(appUser);}
//    @Override
//    public boolean delete(Long id) {
//        boolean found = appUserRepository.existsById(id);
//        if(found) appUserRepository.deleteById(id);
//        return found;
//    }
//
////    @Override
////    public List<AppUser> getAll(String flag) {
////        System.out.println(flag);
////        // this overloaded method takes in a flag and calls the corresponding Repository method:
////        switch(flag) {
////            case "cats":
////                //return employeeRepository.findAll();
////            default:
////                return employeeRepository.findAll();
////        }
////    }
//
//
//    public List<AppUser> findByUsername(String username) {return appUserRepository.findByUsername(username);}

}