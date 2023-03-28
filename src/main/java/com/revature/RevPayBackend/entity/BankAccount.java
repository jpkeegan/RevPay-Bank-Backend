package com.revature.RevPayBackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@Data
@Entity
@Table(name = "BankAccount")


public class BankAccount {
    @Id
    private Long bankAccountId;

    @Column(name = "routing_number")
    private Long routingNumber;

    @Column(name = "account_number")
    private Long accountNumber;

    @Column(name = "account_id")
    private Long accountId;

    @Column (name = "balance")
    private double balance;

}
