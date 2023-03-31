package com.revature.RevPayBackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@NoArgsConstructor@AllArgsConstructor
public class UserAccountUpdateContent {
    public String username;
    public String password;
    public String email;
    public Long phoneNumber;
    public String name;
    public String address;
    public boolean businessAccount;
    public String oldUsername;
}
