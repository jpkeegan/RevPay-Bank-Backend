package com.revature.RevPayBackend.service;

import com.revature.RevPayBackend.entity.BusinessLoan;
import com.revature.RevPayBackend.repository.BusinessLoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessLoanServiceImpl implements BusinessLoanService {

    @Autowired
    BusinessLoanRepository businessLoanRepository;


    @Override
    public BusinessLoan insert(BusinessLoan businessLoan) {
        return businessLoanRepository.save(businessLoan);
    }

    @Override
    public BusinessLoan getById(Long businessLoanId) {
        return businessLoanRepository.findById(businessLoanId).get();
    }

    @Override
    public List<BusinessLoan> getAll() {
        return businessLoanRepository.findAll();
    }

    @Override
    public BusinessLoan update(BusinessLoan businessLoan) {
        return businessLoanRepository.save(businessLoan);
    }

    @Override
    public boolean delete(Long businessLoanId) {
        boolean found = businessLoanRepository.existsById(businessLoanId);
        if(found) {
            businessLoanRepository.deleteById(businessLoanId);
        }
        return found;
    }
}
