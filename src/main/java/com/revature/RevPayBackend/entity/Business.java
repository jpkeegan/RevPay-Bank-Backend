package com.revature.RevPayBackend.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Business {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long businessId;

    @Column(name = "bin")
    private Long bin;
    @Column(name = "ein")
    private Long ein;
    @Column(name = "is_for_profit")
    private boolean forProfit;
    @Column(name = "account_id")
    private Long accountId;


}
