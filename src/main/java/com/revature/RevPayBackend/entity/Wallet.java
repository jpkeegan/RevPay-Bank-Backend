package com.revature.RevPayBackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="wallet")
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long walletId;
    private double balance;

    private Long accountId;

    public Wallet(double balance, long accountId){
        this.balance = balance;
        this.accountId = accountId;
    }
}
