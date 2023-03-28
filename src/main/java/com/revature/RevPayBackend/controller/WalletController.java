package com.revature.RevPayBackend.controller;

import com.revature.RevPayBackend.entity.Wallet;
import com.revature.RevPayBackend.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class WalletController {

    @Autowired
    private WalletService walletService;

    @GetMapping("/wallet/{accountId}")
    public ResponseEntity<Wallet> getWalletByAccountId(@PathVariable("accountId") Long accountId) {
        Wallet wallet = walletService.findByAccountId(accountId);
        return ResponseEntity.ok(wallet);
    }

    @PostMapping("/wallets")
    public ResponseEntity<Wallet> addWallet(@RequestBody Wallet wallet){
        Wallet newWallet = walletService.addWallet(wallet);
        return ResponseEntity.status(HttpStatus.CREATED).body(newWallet);
    }

    @PutMapping("/wallet/{walletId}")
    public ResponseEntity<Wallet> updateWallet(@PathVariable("walletId") Long walletId, @RequestBody Wallet wallet) {
        wallet.setWalletId(walletId);
        Wallet updatedWallet = walletService.updateWallet(wallet);
        return ResponseEntity.ok(updatedWallet);
    }

    @DeleteMapping("/wallets/{walletId}")
    public boolean deleteWallet(@PathVariable("walletId") Long walletId) {
        return walletService.deleteWallet(walletId);
    }
}
