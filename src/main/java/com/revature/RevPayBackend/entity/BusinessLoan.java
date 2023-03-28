package com.revature.RevPayBackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BusinessLoan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loanId;
    private Long amount;
    private String summary;
    private Long businessId;

    public BusinessLoan(Long amount, String summary, Long businessId) {
        this.amount = amount;
        this.summary = summary;
        this.businessId = businessId;
    }

}
