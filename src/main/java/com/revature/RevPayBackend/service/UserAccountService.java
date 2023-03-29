package com.revature.RevPayBackend.service;

import com.revature.RevPayBackend.dto.LoginForm;
import com.revature.RevPayBackend.entity.UserAccount;
import com.revature.RevPayBackend.exceptions.UserExceptions.UserNotFoundException;

import java.util.List;

public interface UserAccountService {
    UserAccount insert(UserAccount userAccount);

    UserAccount update(UserAccount userAccount);

    boolean delete(Long userId);

    UserAccount getById(Long id);

    UserAccount getByUsername(String username);

    List<UserAccount> getAll(boolean flag);

    List<UserAccount> getAll();

    UserAccount verify(LoginForm loginForm) throws UserNotFoundException;
}
