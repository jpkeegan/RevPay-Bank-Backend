package com.revature.RevPayBackend.entity;

import lombok.*;
import javax.persistence.*;
@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
//@Table(name= "app_user")
public class Transaction {
    @Id
    private Long transactionId;
    private double amount;
    private boolean send;
    private long accountId;
    private String accountEmail;
    private long dateTime;


    public Transaction(double amount, boolean send, long accountId, String accountEmail) {
        this.amount = amount;
        this.send = send;
        this.accountId = accountId;
        this.accountEmail = accountEmail;
    }
}