package com.revature.RevPayBackend.service;

import com.revature.RevPayBackend.dto.LoginForm;
import com.revature.RevPayBackend.entity.UserAccount;
import com.revature.RevPayBackend.exceptions.UserExceptions.IdNotFoundException;
import com.revature.RevPayBackend.exceptions.UserExceptions.UserNotFoundException;
import com.revature.RevPayBackend.exceptions.UserExceptions.UsernameNotFoundException;
import com.revature.RevPayBackend.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    @Autowired
    UserAccountRepository userAccountRepository;

    Logger logger1 = LoggerFactory.getLogger(UserAccountServiceImpl.class);
    @Override
    public UserAccount insert(UserAccount userAccount) {
        return userAccountRepository.save(userAccount);
    }

    @Override
    public UserAccount update(UserAccount userAccount) {
        return userAccountRepository.save(userAccount);
    }

    @Override
    public UserAccount resetPassword(UserAccount userAccount) throws UserNotFoundException {
        return userAccountRepository.save(userAccount);
    }

    @Override
    public boolean delete(Long userId) throws IdNotFoundException {
        boolean found = userAccountRepository.existsById(userId);
        if (!found){
            logger1.error("Deletion Failed. No account with id " + userId);
            throw new IdNotFoundException();
        } else {
            logger1.info("Deletion Successful");
            userAccountRepository.deleteById(userId);
            return found;
        }
    }

    @Override
    public UserAccount getById(Long id) throws IdNotFoundException {
        boolean found = userAccountRepository.existsById(id);
        if (!found) throw new IdNotFoundException();
        return userAccountRepository.findById(id).get();
    }

    @Override
    public UserAccount getByUsername(String username) throws UsernameNotFoundException {
        boolean found = userAccountRepository.existsByUsername(username);
        if(!found) throw  new UsernameNotFoundException();
        return userAccountRepository.findByUsername(username);
    }

    @Override
    public List<UserAccount> getAll(boolean flag) {
        if (flag) return userAccountRepository.findByBusinessAccountTrue();
        else return userAccountRepository.findByBusinessAccountFalse();
    }

    @Override
    public List<UserAccount> getAll() {
        return userAccountRepository.findAll();
    }

    @Override
    public UserAccount verify(LoginForm loginForm) throws UserNotFoundException {
        UserAccount returnedUser = userAccountRepository.verifyLogin(loginForm.getUsername(),loginForm.getPassword());
        if(returnedUser == null) throw new UserNotFoundException();
        logger1.info("Login Successful");
        return returnedUser;
    }
}
