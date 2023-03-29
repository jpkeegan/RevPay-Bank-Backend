package com.revature.RevPayBackend.repository;

import com.revature.RevPayBackend.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {


    UserAccount findByUsername(String username);
    List<UserAccount> findByIsBusinessAccountTrue();
    List<UserAccount> findByIsBusinessAccountFalse();
}
