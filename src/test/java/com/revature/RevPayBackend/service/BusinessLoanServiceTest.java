package com.revature.RevPayBackend.service;

import com.revature.RevPayBackend.entity.BusinessLoan;
import com.revature.RevPayBackend.repository.BusinessLoanRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class BusinessLoanServiceTest {

    @MockBean(BusinessLoanRepository.class)
    private BusinessLoanRepository businessLoanRepository;

    @Autowired
    BusinessLoanService businessLoanService;

    @Test
    public void testInsert() {
        BusinessLoan businessLoan = new BusinessLoan(50000l, "test loan summary", -1l);
        BusinessLoan insertedBusinessLoan = new BusinessLoan(2l, 50000l, "test loan summary", -1l);

        Mockito.when(businessLoanRepository.save(businessLoan)).thenReturn(insertedBusinessLoan);

        Assertions.assertEquals(insertedBusinessLoan, businessLoanService.insert(businessLoan));
    }

    @Test
    public void testGetById() {
        Long businessLoanId = 1l;
        BusinessLoan expectedBusinessLoan = new BusinessLoan(1l, 50000l, "test loan summary", -1l);

        Mockito.when(businessLoanRepository.findById(businessLoanId)).thenReturn(Optional.of(expectedBusinessLoan));

        Assertions.assertEquals(expectedBusinessLoan, businessLoanService.getById(businessLoanId));
    }

    @Test
    public void testGetAll() {

        BusinessLoan businessLoan = new BusinessLoan(1l, 50000l, "test loan summary", -1l);
        List<BusinessLoan> businessLoanList = new ArrayList<>();
        businessLoanList.add(businessLoan);

        Mockito.when(businessLoanRepository.findAll()).thenReturn(businessLoanList);

        Assertions.assertEquals(businessLoanList, businessLoanService.getAll());

    }

    @Test
    public void testUpdate() {
        BusinessLoan businessLoan = new BusinessLoan(1l, 50000l, "test loan summary", -1l);
        BusinessLoan updatedBusinessLoan = new BusinessLoan(1l, 50000l, "test loan summary", -1l);

        Mockito.when(businessLoanRepository.save(businessLoan)).thenReturn(updatedBusinessLoan);

        Assertions.assertEquals(updatedBusinessLoan, businessLoanService.update(businessLoan));
    }

    @Test
    public void testDelete() {
        Long businessLoadId = 1l;

        Mockito.when(businessLoanRepository.existsById(businessLoadId)).thenReturn(true);

        Assertions.assertEquals(true, businessLoanService.delete(businessLoadId));
    }

}
