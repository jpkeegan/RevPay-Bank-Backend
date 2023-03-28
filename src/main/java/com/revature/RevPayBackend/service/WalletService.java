package com.revature.RevPayBackend.service;

import com.revature.RevPayBackend.entity.Wallet;

import java.util.Optional;

public interface WalletService {

    Wallet findByAccountId(Long accountId);

    Optional<Wallet> findByWalletId(Long walletId);

    Wallet addWallet(Wallet wallet);

    Wallet updateWallet(Wallet wallet);

    boolean deleteWallet(Long walletId);
}
