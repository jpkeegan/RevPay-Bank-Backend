package com.revature.RevPayBackend.repository;
import com.revature.RevPayBackend.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CardRepo extends JpaRepository<Card, Long> {

    List<Card> findAllByAccountId(Long accountId);
    //    @Query(value = "SELECT c.* FROM card c JOIN user_account ua ON c.account_id = ua.account_id WHERE ua.account_id = :id", nativeQuery = true)



}


