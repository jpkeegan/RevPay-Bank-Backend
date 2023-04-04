package com.revature.RevPayBackend.controller;

import com.revature.RevPayBackend.dto.LoginForm;
import com.revature.RevPayBackend.dto.Origin;
import com.revature.RevPayBackend.dto.UserAccountReturnInfo;
import com.revature.RevPayBackend.entity.UserAccount;
import com.revature.RevPayBackend.exceptions.UserExceptions.UserNotFoundException;
import com.revature.RevPayBackend.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.revature.RevPayBackend.dto.LoginForm.hashPass;

@RestController@RequestMapping("/login")
@CrossOrigin(origins = Origin.origin)
public class LoginController {
    @Autowired
    UserAccountService userAccountService;
    Logger logger1 = LoggerFactory.getLogger(LoginController.class);

    @PatchMapping()
    public ResponseEntity<UserAccountReturnInfo> verifyUser(@RequestBody LoginForm loginForm) throws UserNotFoundException {
        logger1.info("Verifying Login");
        hashPass(loginForm);
        UserAccount returnedUser = userAccountService.verify(loginForm);
        return new ResponseEntity<>(new UserAccountReturnInfo(returnedUser), HttpStatus.OK);
    }


}
