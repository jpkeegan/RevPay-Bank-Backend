package com.revature.RevPayBackend.service;


import com.revature.RevPayBackend.repository.TransactionRepository;
import com.revature.RevPayBackend.entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
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
    public List<Transaction> getAllByAccountId(Long id) {
        return transactionRepository.findAllByAccountId(id);
    }

    @Override
    public List<Transaction> getByTimeRange(Long id, Long timeBegin) {
        Long timeEnd = increaseDateByMonth(timeBegin);
        return transactionRepository.findByIdAndTimeRange(id, timeBegin,timeEnd);
    }

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

    private long increaseDateByMonth(long time){
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(time);
        Calendar cal2 = Calendar.getInstance();
        cal2.clear();
        cal2.set(cal.get(Calendar.YEAR),cal.get(Calendar.MONTH)+1, cal.get(Calendar.DATE));
        return cal2.getTimeInMillis();
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