package com.revature.RevPayBackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Data@NoArgsConstructor@AllArgsConstructor
public class LoginForm {
    private String username;
    private String password;


    public static void hashPass(LoginForm loginForm){
        try{
            MessageDigest messageDigest = MessageDigest.getInstance("SHA");
            messageDigest.update(loginForm.getPassword().getBytes());
            byte[] result = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b: result){
                sb.append(String.format("%02x",b));
            }
            loginForm.setPassword(sb.toString());
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }

    }
}
