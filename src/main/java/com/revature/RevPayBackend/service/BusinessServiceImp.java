package com.revature.RevPayBackend.service;

import com.revature.RevPayBackend.entity.Business;
import com.revature.RevPayBackend.entity.Wallet;
import com.revature.RevPayBackend.exceptions.UserExceptions.IdNotFoundException;
import com.revature.RevPayBackend.repository.BusinessRepsository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessServiceImp implements BusinessService{

    @Autowired
    BusinessRepsository businessRepository;
    @Override
    public Business insert(Business business) {
        return businessRepository.save(business);
    }

    @Override
    public Business getById(Long id) {
        return businessRepository.findById(id).get();
    }

    @Override
    public List<Business> getAll() {
        return businessRepository.findAll();
    }

    @Override
    public Business update(Business business) {
        return businessRepository.save(business);
    }

    @Override
    public boolean delete(Long id) {
        boolean found = businessRepository.existsById(id);
        if(found) businessRepository.deleteById(id);
        return found;
    }

    @Override
    public Business findByAccountId(Long accountId) throws IdNotFoundException {
        Business business = businessRepository.findByAccountId(accountId);
        if (business == null) {
            throw new IdNotFoundException();
        }
        return business;
    }
}
