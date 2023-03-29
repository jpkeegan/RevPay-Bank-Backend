package com.revature.RevPayBackend.daotest;

import com.revature.RevPayBackend.entity.Wallet;
import com.revature.RevPayBackend.repository.WalletRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class WalletDaoTest {

    @Autowired
    private WalletRepository walletRepository;


    @Test
    public void whenFindByAccountId_thenReturnWallet() {
        // given
        double balance = 100.0;
        long accountId = 1L;

        Wallet wallet = new Wallet(balance, accountId);
        walletRepository.save(wallet);

        // when
        Optional<Wallet> found = Optional.ofNullable(walletRepository.findByAccountId(accountId));

        // then
        assertThat(found).isPresent();
        assertThat(found.get().getBalance()).isEqualTo(balance);
        assertThat(found.get().getAccountId()).isEqualTo(accountId);
    }

    @Test
    public void whenSaveWallet_thenFindById() {
        // given
        double balance = 200.0;
        long accountId = 2L;

        Wallet wallet = new Wallet(balance, accountId);
        walletRepository.save(wallet);

        // when
        Optional<Wallet> found = walletRepository.findById(wallet.getWalletId());

        // then
        assertThat(found).isPresent();
        assertThat(found.get().getBalance()).isEqualTo(balance);
        assertThat(found.get().getAccountId()).isEqualTo(accountId);
    }

}
