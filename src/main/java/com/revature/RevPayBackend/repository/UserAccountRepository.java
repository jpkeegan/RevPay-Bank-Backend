package com.revature.RevPayBackend.repository;

import com.revature.RevPayBackend.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

    @Query(value = "SELECT * FROM user_account WHERE username=:theUsername and password=:thePassword",nativeQuery = true)
    UserAccount verifyLogin(@Param("theUsername") String theUsername,@Param("thePassword") String thePassword);


    UserAccount findByUsername(String username);
    List<UserAccount> findByIsBusinessAccountTrue();
    List<UserAccount> findByIsBusinessAccountFalse();

    boolean existsByUsername(String username);
}
