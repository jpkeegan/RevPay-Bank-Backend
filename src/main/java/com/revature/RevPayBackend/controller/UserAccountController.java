package com.revature.RevPayBackend.controller;

import com.revature.RevPayBackend.dto.UserAccountReturnInfo;
import com.revature.RevPayBackend.entity.UserAccount;
import com.revature.RevPayBackend.service.UserAccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/userAccount")
@CrossOrigin(origins = "*")
public class UserAccountController {

    @Autowired
    UserAccountService userAccountService;



    Logger logger1 = LoggerFactory.getLogger(UserAccountController.class);

    @PostMapping()
    public UserAccountReturnInfo insert(@RequestBody UserAccount userAccount){
        logger1.info("Inserting..." +userAccount.toString());
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
    public UserAccountReturnInfo getByIdOrUsername(@PathVariable("userIdentifier") String identifier){
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

    @PutMapping()
    public UserAccountReturnInfo update(@RequestBody UserAccount userAccount){
        logger1.info("Updating user "+userAccount.toString() );
        UserAccount returnedUser = userAccountService.update(userAccount);
        return new UserAccountReturnInfo(returnedUser);
    }

    @DeleteMapping("/{userAccountId}")
    public boolean delete(@PathVariable("userAccountId") Long userId){
        logger1.info("Attempting deletion of user by id = "+userId.toString() );
        return userAccountService.delete(userId);
    }

}
