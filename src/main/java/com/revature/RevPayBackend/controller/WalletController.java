package com.revature.RevPayBackend.controller;

import com.revature.RevPayBackend.entity.Wallet;
import com.revature.RevPayBackend.service.WalletService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class WalletController {

    @Autowired
    private WalletService walletService;

    private Logger logger = LoggerFactory.getLogger(WalletController.class);

    @GetMapping("/wallet/{accountId}")
    public ResponseEntity<Wallet> getWalletByAccountId(@PathVariable("accountId") Long accountId) {
        Wallet wallet = walletService.findByAccountId(accountId);
        logger.info("Getting wallet from account: " + accountId);
        return ResponseEntity.ok(wallet);
    }

    @PostMapping("/wallets")
    public ResponseEntity<Wallet> addWallet(@RequestBody Wallet wallet){
        Wallet newWallet = walletService.addWallet(wallet);
        logger.info("Adding wallet " + wallet + " to account " + wallet.getAccountId());
        return ResponseEntity.status(HttpStatus.CREATED).body(newWallet);
    }

    @PutMapping("/wallet/{walletId}")
    public ResponseEntity<Wallet> updateWallet(@PathVariable("walletId") Long walletId, @RequestBody Wallet wallet) {
        wallet.setWalletId(walletId);
        Wallet updatedWallet = walletService.updateWallet(wallet);
        logger.info("Updating wallet " + wallet + " to " + updatedWallet);
        return ResponseEntity.ok(updatedWallet);
    }

    @DeleteMapping("/wallets/{walletId}")
    public boolean deleteWallet(@PathVariable("walletId") Long walletId) {
        logger.info("Deleting Wallet with Id: " + walletId);
        return walletService.deleteWallet(walletId);
    }
}
