package com.revature.RevPayBackend.controller;

import com.revature.RevPayBackend.dto.BusinessAccountReturn;
import com.revature.RevPayBackend.dto.Origin;
import com.revature.RevPayBackend.entity.Wallet;
import com.revature.RevPayBackend.exceptions.UserExceptions.IdNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.revature.RevPayBackend.entity.Business;
import com.revature.RevPayBackend.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {Origin.origin,Origin.localhost})
@RestController
@RequestMapping("/businesses")
public class BusinessController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    BusinessService businessService;

    @PostMapping()
    public ResponseEntity<Business> insert(@RequestBody BusinessAccountReturn rbusiness){
        Business business = new Business(rbusiness.getBusinessId(), rbusiness.getBin(), rbusiness.getEin(), rbusiness.isForProfit(), rbusiness.getAccountId());
        logger.info("Object made: " + business.toString());
        return new ResponseEntity<>(businessService.insert(business), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Business> getById(@PathVariable("id") Long identifier){
        try {
            Business result = businessService.getById(identifier);
            logger.info("Object fetched: " + result.toString());
            return new ResponseEntity<>(result,HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(new Business(),HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/account/{id}")
    public ResponseEntity<Business> getByAccountId(@PathVariable("id") Long identifier){
        try {
            Business result = businessService.getByAccountId(identifier);
            logger.info("Object fetched: " + result.toString());
            return new ResponseEntity<>(result,HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(new Business(),HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping()
    public ResponseEntity<Business> update(@RequestBody Business business){
        try{
            logger.info("Object updated: " + business.toString());
            return new ResponseEntity<>(businessService.update(business),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(new Business(),HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{deleteId}")
    public boolean delete(@PathVariable("deleteId") Long id){
        return businessService.delete(id);
    }



}
