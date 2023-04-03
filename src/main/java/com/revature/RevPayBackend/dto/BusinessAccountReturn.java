package com.revature.RevPayBackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BusinessAccountReturn {

    private Long businessId;
    private Long bin;
    private Long ein;
    private boolean forProfit;
    private Long accountid;

}