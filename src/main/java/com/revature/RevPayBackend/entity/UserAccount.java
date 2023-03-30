package com.revature.RevPayBackend.entity;

import com.revature.RevPayBackend.dto.UserAccountReturnInfo;
import com.revature.RevPayBackend.dto.UserAccountUpdateContent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
    public boolean businessAccount;

    public UserAccount(String username, String password, String email, Long phoneNumber, String name, String address, boolean businessAccount){
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.address = address;
        this.businessAccount = businessAccount;
    }

    public UserAccount(Long userAccountId, UserAccountUpdateContent userAccountUpdateContent){
        this.accountId = userAccountId;
        this.username = userAccountUpdateContent.getUsername();
        this.password = userAccountUpdateContent.getPassword();
        this.email = userAccountUpdateContent.getEmail();
        this.phoneNumber = userAccountUpdateContent.getPhoneNumber();
        this.name = userAccountUpdateContent.getName();
        this.address = userAccountUpdateContent.getAddress();
        this.businessAccount = userAccountUpdateContent.isBusinessAccount();
    }


    public static void hashPassUA(UserAccount userAccount){
        try{
            MessageDigest messageDigest = MessageDigest.getInstance("SHA");
            messageDigest.update(userAccount.getPassword().getBytes());
            byte[] result = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b: result){
                sb.append(String.format("%02x",b));
            }
            userAccount.setPassword(sb.toString());
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }

    }
}
