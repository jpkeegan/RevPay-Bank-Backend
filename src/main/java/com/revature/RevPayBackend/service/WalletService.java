package com.revature.RevPayBackend.service;

import com.revature.RevPayBackend.entity.Wallet;
import com.revature.RevPayBackend.exceptions.UserExceptions.IdNotFoundException;

import java.util.Optional;

public interface WalletService {

    Wallet findByAccountId(Long accountId) throws IdNotFoundException;

    Optional<Wallet> findByWalletId(Long walletId) throws IdNotFoundException;

    Wallet addWallet(Wallet wallet);

    Wallet updateWallet(Wallet wallet);

    boolean deleteWallet(Long walletId) throws IdNotFoundException;
}
