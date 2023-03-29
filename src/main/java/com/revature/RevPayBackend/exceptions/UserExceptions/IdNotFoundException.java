package com.revature.RevPayBackend.exceptions.UserExceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class IdNotFoundException extends Exception {
    Logger logger1 = LoggerFactory.getLogger(IdNotFoundException.class);

    public IdNotFoundException() {
        super("Id Not Found");
        logger1.error("Id Not Found");
    }
}
