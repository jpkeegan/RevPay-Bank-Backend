package com.revature.RevPayBackend.entity;

import com.revature.RevPayBackend.dto.UserAccountReturnInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_account")
public class UserAccount extends UserAccountReturnInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long accountId;
    public String username;
    public String password;
    public String email;
    public Long phoneNumber;
    public String name;
    public String address;
    public boolean isBusinessAccount;

    public UserAccount(String username, String password, String email, Long phoneNumber, String name, String address, boolean isBusinessAccount){
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.address = address;
        this.isBusinessAccount = isBusinessAccount;
    }
}
