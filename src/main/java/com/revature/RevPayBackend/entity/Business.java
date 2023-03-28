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

    @Column
    private Long bin;
    @Column
    private Long ein;
    @Column
    private boolean isForProfit;
    @Column
    private Long accountId;


}
