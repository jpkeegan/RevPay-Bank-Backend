package com.revature.RevPayBackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "bank_account")


public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bank_account_id")
    private Long bankAccountId;

    @Column(name = "routing_number")
    private Long routingNumber;

    @Column(name = "account_number")
    private Long accountNumber;

    @Column(name = "account_id")
    private Long accountId;

    @Column (name = "balance")
    private double balance;

    public BankAccount(Long routingNumber, Long accountNumber) {
        this.routingNumber = routingNumber;
        this.accountNumber = accountNumber;
    }
}
