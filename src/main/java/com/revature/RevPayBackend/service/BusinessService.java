package com.revature.RevPayBackend.service;

import com.revature.RevPayBackend.entity.Business;
import com.revature.RevPayBackend.exceptions.UserExceptions.IdNotFoundException;

import java.util.List;

public interface BusinessService {
    Business insert(Business business);
    Business getById(Long id);
    List<Business> getAll();
    Business update(Business business);
    boolean delete(Long id);

    Business findByAccountId(Long accountId) throws IdNotFoundException;
}
