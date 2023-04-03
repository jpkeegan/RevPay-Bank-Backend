package com.revature.RevPayBackend.controller;

import com.revature.RevPayBackend.dto.LoginForm;
import com.revature.RevPayBackend.dto.PasswordChange;
import com.revature.RevPayBackend.dto.UserAccountReturnInfo;
import com.revature.RevPayBackend.dto.UserAccountUpdateContent;
import com.revature.RevPayBackend.entity.UserAccount;
import com.revature.RevPayBackend.exceptions.UserExceptions.IdNotFoundException;
import com.revature.RevPayBackend.exceptions.UserExceptions.UserNotFoundException;
import com.revature.RevPayBackend.exceptions.UserExceptions.UsernameNotFoundException;
import com.revature.RevPayBackend.service.UserAccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.revature.RevPayBackend.dto.LoginForm.hashPass;
import static com.revature.RevPayBackend.entity.UserAccount.hashPassUA;


@RestController
@RequestMapping("/userAccount")
@CrossOrigin(origins = "*")
public class UserAccountController {
    @Autowired
    UserAccountService userAccountService;

    Logger logger1 = LoggerFactory.getLogger(UserAccountController.class);

    @PostMapping()
    public UserAccountReturnInfo insert(@RequestBody UserAccount userAccount){
        logger1.info("Inserting..." +userAccount.getUsername());
        hashPassUA(userAccount);
        UserAccount returnedUser = userAccountService.insert(userAccount);
        return new UserAccountReturnInfo(returnedUser);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<UserAccountReturnInfo> getAll(@RequestParam(required = false, value = "isBusinessAccount") String flag){
        if (flag == null){
            logger1.info("Retrieving all users.");
            List<UserAccount> allReturned =  userAccountService.getAll();
            List<UserAccountReturnInfo> privateAllReturn = new ArrayList<>();
            int listLength = allReturned.size()-1;
            while (listLength>=0){
                privateAllReturn.add(new UserAccountReturnInfo(allReturned.get(listLength)));
                listLength--;
            }
            return privateAllReturn;
        }
        else {
            List<UserAccount> allReturned = new ArrayList<>();
            if (flag.equalsIgnoreCase("true")){
                logger1.info("Retrieving users with business accounts.");
                allReturned =  userAccountService.getAll(true);
            } else if (flag.equalsIgnoreCase("false")) {
                logger1.info("Retrieving users with personal accounts.");
                allReturned =  userAccountService.getAll(false);
            }else {
                logger1.error("Invalid Flag.");
                logger1.info("Retrieving all users.");
                allReturned =  userAccountService.getAll();
            }
            List<UserAccountReturnInfo> privateAllReturn = new ArrayList<>();
            int listLength = allReturned.size()-1;
            while (listLength>=0){
                privateAllReturn.add(new UserAccountReturnInfo(allReturned.get(listLength)));
                listLength--;
            }
            return privateAllReturn;
        }
    }

    @GetMapping("/{userIdentifier}")
    public UserAccountReturnInfo getByIdOrUsername(@PathVariable("userIdentifier") String identifier) throws IdNotFoundException, UsernameNotFoundException {
        try{
            Long id = Long.parseLong(identifier);
            logger1.info("Attempting to retrieve by user id = "+identifier );
            UserAccount returnedUser = userAccountService.getById(id);
            return new UserAccountReturnInfo(returnedUser);
        }
        catch (Exception e){
            logger1.info("Attempting to retrieve by username = "+identifier );
            UserAccount returnedUser = userAccountService.getByUsername(identifier);
            return new UserAccountReturnInfo(returnedUser);
        }
    }

    @PutMapping("/{userAccountId}")
    public UserAccountReturnInfo update(@PathVariable("userAccountId") Long userAccountId, @RequestBody UserAccountUpdateContent userAccountUpdateContent) throws UserNotFoundException {
        logger1.info("Must validate update authorization.");
        LoginForm verifyLogin = new LoginForm(userAccountUpdateContent.getOldUsername(), userAccountUpdateContent.getPassword());
        logger1.info("Verifying Login");
        hashPass(verifyLogin);
        UserAccount returnedUser = userAccountService.verify(verifyLogin);
        if (returnedUser == null){
            logger1.error("Not Authorized to update User Info");
        } else {
            logger1.info("Updating user ID: "+userAccountId.toString() );
            UserAccount userAccount = new UserAccount(userAccountId, userAccountUpdateContent);
            hashPassUA(userAccount);
            returnedUser = userAccountService.update(userAccount);
        }
        return new UserAccountReturnInfo(returnedUser);
    }

    @PutMapping("/passwordReset/{userAccountId}")
    public UserAccountReturnInfo resetPassword(@PathVariable("userAccountId") Long userAccountId, @RequestBody PasswordChange passwordChange) throws UserNotFoundException {
        LoginForm verifyLogin = new LoginForm(passwordChange.getUsername(), passwordChange.getOldPassword());
        logger1.info("Verifying credentials to update password");
        hashPass(verifyLogin);
        UserAccount returnedUser = userAccountService.verify(verifyLogin);
        if (returnedUser == null) {
            logger1.info("Not authorized to change password");
        } else {
            logger1.info("Updating user's password");
            returnedUser.setPassword(passwordChange.getPassword());
            hashPassUA(returnedUser);
            returnedUser = userAccountService.update(returnedUser);
        }
        return new UserAccountReturnInfo(returnedUser);
    }

    @DeleteMapping("/{userAccountId}")
    public boolean delete(@PathVariable("userAccountId") Long userId) throws IdNotFoundException{
        logger1.info("Attempting deletion of user by ID: "+userId.toString() );
        return userAccountService.delete(userId);
    }

}
