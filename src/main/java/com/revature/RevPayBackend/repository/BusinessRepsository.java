package com.revature.RevPayBackend.repository;

import com.revature.RevPayBackend.entity.Business;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessRepsository  extends JpaRepository<Business,Long> {

    Business findByAccountId(Long accountId);
}
