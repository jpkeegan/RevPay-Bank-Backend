package com.revature.RevPayBackend.repository;

import com.revature.RevPayBackend.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository  extends JpaRepository<Wallet, Long> {

    Wallet findByAccountId(Long accountId);

}
