package com.revature.RevPayBackend.service;

import com.revature.RevPayBackend.entity.BusinessLoan;
import com.revature.RevPayBackend.exceptions.UserExceptions.IdNotFoundException;

import java.util.List;

public interface BusinessLoanService {
    BusinessLoan insert(BusinessLoan businessLoan);
    BusinessLoan getById(Long businessLoanId) throws IdNotFoundException;
    List<BusinessLoan> getAll();
    BusinessLoan update(BusinessLoan businessLoan) throws IdNotFoundException;
    boolean delete(Long businessLoanId) throws IdNotFoundException;

    List<BusinessLoan> getByBusinessId(Long businessId) throws IdNotFoundException;
}
