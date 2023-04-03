package com.revature.RevPayBackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PasswordChange {
    public String username;
    public String oldPassword;
    public String password;
}
