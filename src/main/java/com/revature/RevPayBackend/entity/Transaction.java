package com.revature.RevPayBackend.entity;

import lombok.*;
import javax.persistence.*;
@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
@Table(name= "transaction_table")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;
    private double amount;
    private boolean send;
    private long accountId;
    private long senderAccountId;
    private String accountEmail;
    private long dateTime;


    public Transaction(double amount, boolean send, long accountId, long senderAccountId,String accountEmail, long dateTime) {
        this.amount = amount;
        this.send = send;
        this.accountId = accountId;
        this.senderAccountId = senderAccountId;
        this.accountEmail = accountEmail;
        this.dateTime = dateTime;
    }


}