package com.revature.RevPayBackend.service;

import com.revature.RevPayBackend.dto.LoginForm;
import com.revature.RevPayBackend.entity.UserAccount;
import com.revature.RevPayBackend.exceptions.UserExceptions.IdNotFoundException;
import com.revature.RevPayBackend.exceptions.UserExceptions.UserNotFoundException;
import com.revature.RevPayBackend.exceptions.UserExceptions.UsernameNotFoundException;

import java.util.List;

public interface UserAccountService {
    UserAccount insert(UserAccount userAccount);

    UserAccount update(UserAccount userAccount);

    boolean delete(Long userId) throws IdNotFoundException;

    UserAccount getById(Long id) throws IdNotFoundException;

    UserAccount getByUsername(String username)throws UsernameNotFoundException;

    List<UserAccount> getAll(boolean flag);

    List<UserAccount> getAll();

    UserAccount verify(LoginForm loginForm) throws UserNotFoundException;
}
