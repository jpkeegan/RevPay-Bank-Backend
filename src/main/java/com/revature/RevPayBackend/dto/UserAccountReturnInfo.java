package com.revature.RevPayBackend.dto;

import com.revature.RevPayBackend.entity.UserAccount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@NoArgsConstructor@AllArgsConstructor
public class UserAccountReturnInfo {
    public Long accountId;
    public String username;
    public String email;
    public Long phoneNumber;
    public String name;
    public String address;
    public boolean businessAccount;

    public UserAccountReturnInfo(UserAccount userAccount){
        this.accountId = userAccount.getAccountId();
        this.username = userAccount.getUsername();
        this.email = userAccount.getEmail();
        this.phoneNumber = userAccount.getPhoneNumber();
        this.name = userAccount.getName();
        this.address = userAccount.getAddress();
        this.businessAccount = userAccount.isBusinessAccount();
    }
}
