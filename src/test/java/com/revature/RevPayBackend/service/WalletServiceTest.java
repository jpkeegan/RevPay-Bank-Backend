package com.revature.RevPayBackend.service;

import com.revature.RevPayBackend.entity.Wallet;
import com.revature.RevPayBackend.exceptions.UserExceptions.IdNotFoundException;
import com.revature.RevPayBackend.repository.WalletRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@SpringBootTest
public class WalletServiceTest {

    @Mock
    private WalletRepository walletRepository;

    @InjectMocks
    private WalletServiceImpl walletService;

    @Test
    public void whenFindByAccountId_thenReturnWallet() throws IdNotFoundException{
        // given
        double balance = 100.0;
        long accountId = 1L;

        Wallet wallet = new Wallet(balance, accountId);
        when(walletRepository.findByAccountId(accountId)).thenReturn(wallet);

        // when
        Wallet found = walletService.findByAccountId(accountId);

        // then
        assertThat(found).isNotNull();
        assertThat(found.getBalance()).isEqualTo(balance);
        assertThat(found.getAccountId()).isEqualTo(accountId);
    }

    @Test
    public void whenFindByWalletId_thenReturnWallet() throws IdNotFoundException{
        // given
        double balance = 200.0;
        long walletId = 2L;

        Wallet wallet = new Wallet(balance, 1L);
        wallet.setWalletId(walletId);
        when(walletRepository.findById(walletId)).thenReturn(Optional.of(wallet));

        // when
        Optional<Wallet> found = walletService.findByWalletId(walletId);

        // then
        assertThat(found).isPresent();
        assertThat(found.get().getBalance()).isEqualTo(balance);
        assertThat(found.get().getAccountId()).isEqualTo(1L);
    }

    @Test
    public void whenAddWallet_thenReturnWallet() {
        // given
        double balance = 300.0;
        long accountId = 3L;

        Wallet wallet = new Wallet(balance, accountId);
        when(walletRepository.save(wallet)).thenReturn(wallet);

        // when
        Wallet savedWallet = walletService.addWallet(wallet);

        // then
        assertThat(savedWallet).isNotNull();
        assertThat(savedWallet.getBalance()).isEqualTo(balance);
        assertThat(savedWallet.getAccountId()).isEqualTo(accountId);
    }

    @Test
    public void whenUpdateWallet_thenReturnWallet() {
        // given
        double balance = 400.0;
        long accountId = 4L;
        long walletId = 4L;

        Wallet wallet = new Wallet(balance, accountId);
        wallet.setWalletId(walletId);
        when(walletRepository.save(wallet)).thenReturn(wallet);

        // when
        Wallet updatedWallet = walletService.updateWallet(wallet);

        // then
        assertThat(updatedWallet).isNotNull();
        assertThat(updatedWallet.getBalance()).isEqualTo(balance);
        assertThat(updatedWallet.getAccountId()).isEqualTo(accountId);
        assertThat(updatedWallet.getWalletId()).isEqualTo(walletId);
    }

    @Test
    public void whenDeleteWallet_thenVerify()  throws IdNotFoundException {
        // given
        long walletId = 5L;

        when(walletRepository.findById(walletId)).thenReturn(Optional.of(new Wallet()));

        // when
        boolean deleted = walletService.deleteWallet(walletId);

        // then
        assertThat(deleted).isTrue();
    }

    @Test
    public void whenDeleteNonExistingWallet_thenVerify() throws IdNotFoundException{
        // given
        long walletId = 6L;

        when(walletRepository.findById(anyLong())).thenReturn(Optional.empty());

        // when
        boolean deleted = walletService.deleteWallet(walletId);

        // then
        assertThat(deleted).isFalse();
    }
}
