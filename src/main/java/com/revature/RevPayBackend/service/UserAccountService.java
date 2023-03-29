package com.revature.RevPayBackend.service;

import com.revature.RevPayBackend.entity.UserAccount;

import java.util.List;

public interface UserAccountService {
    UserAccount insert(UserAccount userAccount);

    UserAccount update(UserAccount userAccount);

    boolean delete(Long userId);

    UserAccount getById(Long id);

    UserAccount getByUsername(String username);

    List<UserAccount> getAll(boolean flag);

    List<UserAccount> getAll();
}
