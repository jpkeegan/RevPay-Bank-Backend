package com.revature.RevPayBackend.service;

import com.revature.RevPayBackend.entity.Wallet;
import com.revature.RevPayBackend.exceptions.UserExceptions.IdNotFoundException;
import com.revature.RevPayBackend.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WalletServiceImpl implements WalletService{

    @Autowired
    private WalletRepository walletRepository;

    @Override
    public Wallet findByAccountId(Long accountId) throws IdNotFoundException {
        Wallet wallet = walletRepository.findByAccountId(accountId);
        if (wallet == null) {
            throw new IdNotFoundException();
        }
        return wallet;
    }

    @Override
    public Optional<Wallet> findByWalletId(Long walletId) throws IdNotFoundException {
        Optional<Wallet> walletOptional = walletRepository.findById(walletId);
        if (walletOptional.isEmpty()) {
            throw new IdNotFoundException();
        }
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
    public boolean deleteWallet(Long walletId) throws IdNotFoundException {
        Optional<Wallet> walletOptional = walletRepository.findById(walletId);
        if (walletOptional.isPresent()) {
            walletRepository.delete(walletOptional.get());
            return true;
        }
        throw new IdNotFoundException();
    }

}
