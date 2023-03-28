package com.revature.RevPayBackend.repository;

import com.revature.RevPayBackend.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    //List<AppUser> findByUsername(String username);
    //AppUser login(AppUser appUser);


}