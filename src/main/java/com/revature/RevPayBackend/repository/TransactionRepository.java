package com.revature.RevPayBackend.repository;

import com.revature.RevPayBackend.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query(value = "SELECT * FROM transaction_table WHERE (account_id=:id or sender_account_id=:id) and date_time>=:timeBegin and date_time<:timeEnd ORDER BY date_time ASC", nativeQuery = true)
    List<Transaction> findByIdAndTimeRange(@Param("id") Long id, @Param("timeBegin") Long timeBegin,@Param("timeEnd") Long timeEnd);

    @Query(value = "SELECT * FROM transaction_table WHERE account_id=:id or sender_account_id=:id", nativeQuery = true)
    List<Transaction> findAllByAccountId(@Param("id") Long id);
}