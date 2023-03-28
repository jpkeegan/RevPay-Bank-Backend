package com.revature.RevPayBackend.service;

import com.revature.RevPayBackend.entity.BusinessLoan;

import java.util.List;

public interface BusinessLoanService {
    BusinessLoan insert(BusinessLoan businessLoan);
    BusinessLoan getById(Long businessLoanId);
    List<BusinessLoan> getAll();
    BusinessLoan update(BusinessLoan businessLoan);
    boolean delete(Long businessLoanId);
}
