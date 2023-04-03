package com.revature.RevPayBackend.repository;

import com.revature.RevPayBackend.entity.BusinessLoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusinessLoanRepository extends JpaRepository<BusinessLoan, Long> {

    List<BusinessLoan> findByBusinessId(Long businessId);
}
