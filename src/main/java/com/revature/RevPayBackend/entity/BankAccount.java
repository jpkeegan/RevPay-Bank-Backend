package com.revature.RevPayBackend.entity;

import com.revature.RevPayBackend.dto.BankAccountInput;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Random;

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

    public BankAccount(BankAccountInput bankAccountInput){
        this.routingNumber = bankAccountInput.getRoutingNumber();
        this.accountNumber = bankAccountInput.getAccountNumber();
        this.accountId = bankAccountInput.getAccountId();
        this.balance = Math.round(randomBalance() *100.0)/100.0;
    }

    private double randomBalance(){
        Random r = new Random();
        return (1000.00 +(9000.00 * r.nextDouble()));
    }
}
