package com.revature.RevPayBackend.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class BusinessAccountReturn {

    private Long businessId;
    private Long bin;
    private Long ein;
    private boolean isForProfit;
    private Long accountid;

    public Long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Long businessId) {
        this.businessId = businessId;
    }

    public Long getBin() {
        return bin;
    }

    public void setBin(Long bin) {
        this.bin = bin;
    }

    public Long getEin() {
        return ein;
    }

    public void setEin(Long ein) {
        this.ein = ein;
    }

    public boolean isForProfit() {
        return isForProfit;
    }

    public void setIsForProfit(boolean forProfit) {
        isForProfit = forProfit;
    }

    public Long getAccountId() {
        return accountid;
    }

    public void setAccountId(Long accountid) {
        this.accountid = accountid;
    }
}
