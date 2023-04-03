package com.revature.RevPayBackend.service;

import com.revature.RevPayBackend.entity.BusinessLoan;
import com.revature.RevPayBackend.exceptions.UserExceptions.IdNotFoundException;
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
    public BusinessLoan getById(Long businessLoanId) throws IdNotFoundException {
        if(!businessLoanRepository.existsById(businessLoanId)) throw new IdNotFoundException();
        return businessLoanRepository.findById(businessLoanId).get();
    }

    @Override
    public List<BusinessLoan> getAll() {
        return businessLoanRepository.findAll();
    }

    @Override
    public BusinessLoan update(BusinessLoan businessLoan) throws IdNotFoundException {
        if(!businessLoanRepository.existsById(businessLoan.getLoanId())) throw new IdNotFoundException();
        return businessLoanRepository.save(businessLoan);
    }

    @Override
    public boolean delete(Long businessLoanId) throws IdNotFoundException {
        if(!businessLoanRepository.existsById(businessLoanId)) throw new IdNotFoundException();
        boolean found = businessLoanRepository.existsById(businessLoanId);
        if(found) {
            businessLoanRepository.deleteById(businessLoanId);
        }
        return found;
    }

    @Override
    public List<BusinessLoan> getByBusinessId(Long businessId) throws IdNotFoundException {
        List<BusinessLoan> businessLoans = businessLoanRepository.findByBusinessId(businessId);
        return businessLoans;
    }
}
