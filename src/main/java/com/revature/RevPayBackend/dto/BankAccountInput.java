package com.revature.RevPayBackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankAccountInput {
    private Long routingNumber;
    private Long accountNumber;
    private Long accountId;
}
