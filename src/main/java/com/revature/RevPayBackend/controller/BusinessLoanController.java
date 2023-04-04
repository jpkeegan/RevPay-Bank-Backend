package com.revature.RevPayBackend.controller;

import com.revature.RevPayBackend.dto.Origin;
import com.revature.RevPayBackend.entity.BusinessLoan;
import com.revature.RevPayBackend.exceptions.UserExceptions.IdNotFoundException;
import com.revature.RevPayBackend.service.BusinessLoanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {Origin.origin,Origin.localhost})
@RestController
@RequestMapping("/businessloans")
public class BusinessLoanController {

    @Autowired
    BusinessLoanService businessLoanService;

    Logger logger = LoggerFactory.getLogger(BusinessLoanController.class);

    @PostMapping()
    public ResponseEntity<BusinessLoan> insert(@RequestBody BusinessLoan businessLoan) {
        logger.info("Inserting: " + businessLoan.toString());
        return new ResponseEntity<BusinessLoan>(businessLoanService.insert(businessLoan), HttpStatus.CREATED);
    }

    @GetMapping()
    public List<BusinessLoan> getAll() {
        logger.info("Getting all business loans");
        return businessLoanService.getAll();
    }

    @GetMapping("/{businessLoanId}")
    public BusinessLoan getById(@PathVariable("businessLoanId") Long id) throws IdNotFoundException {
        logger.info("Getting business loan of ID: " + id);
        return businessLoanService.getById(id);
    }


    @PutMapping()
    public BusinessLoan update(@RequestBody BusinessLoan businessLoan) throws IdNotFoundException {
        logger.info("Updating: " + businessLoan.toString());
        return businessLoanService.update(businessLoan);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") Long id) throws IdNotFoundException {
        logger.info("Deleting business loan of ID: " + id);
        return businessLoanService.delete(id);
    }

    @GetMapping("/business/{businessId}")
    public List<BusinessLoan> getByBusinessId(@PathVariable("businessId") Long businessId) throws IdNotFoundException {
        logger.info("Getting business loans of business ID: " + businessId);
        return businessLoanService.getByBusinessId(businessId);
    }

}
