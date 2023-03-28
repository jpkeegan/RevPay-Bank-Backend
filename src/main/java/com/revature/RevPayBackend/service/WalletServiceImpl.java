package com.revature.RevPayBackend.service;

import com.revature.RevPayBackend.entity.Wallet;
import com.revature.RevPayBackend.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WalletServiceImpl implements WalletService{

    @Autowired
    private WalletRepository walletRepository;

    @Override
    public Wallet findByAccountId(Long accountId) {
        return walletRepository.findByAccountId(accountId);
    }

    @Override
    public Optional<Wallet> findByWalletId(Long walletId) {
        Optional<Wallet> walletOptional = walletRepository.findById(walletId);
        return walletOptional;
    }

    @Override
    public Wallet addWallet(Wallet wallet) {
        return walletRepository.save(wallet);
    }

    @Override
    public Wallet updateWallet(Wallet wallet) {
        return walletRepository.save(wallet);
    }

    @Override
    public boolean deleteWallet(Long walletId) {
        Optional<Wallet> walletOptional = walletRepository.findById(walletId);
        if (walletOptional.isPresent()) {
            walletRepository.delete(walletOptional.get());
            return true;
        }
        return false;
    }

}
