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
    private Long accountId;


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
        return forProfit;
    }

    public void setForProfit(boolean forProfit) {
        this.forProfit = forProfit;
    }
}