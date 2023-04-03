package com.revature.RevPayBackend.service;

import com.revature.RevPayBackend.entity.Business;
import com.revature.RevPayBackend.repository.BusinessRepsository;
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
public class BusinessServiceTest {

    @MockBean(BusinessRepsository.class)
    private BusinessRepsository br;

    @Autowired
    BusinessServiceImp bs;


    @Test
    void testInsert() {
        Business nb = new Business();
        nb.setBin(32561l);
        nb.setEin(52723l);
        nb.setIsForProfit(false);
        nb.setAccountId(10l);
        Business returnValue = new Business(1l,32561l,52723l,false,10l);
        Mockito.when(br.save(nb)).thenReturn(returnValue);
        Assertions.assertEquals(returnValue,bs.insert(nb));
    }

    @Test
    void testGetById() {
        Business b1 = new Business(1l,1729l,4569l,false,5l);
        Mockito.when(br.findById(1l)).thenReturn(Optional.of(b1));
        Assertions.assertEquals(b1,bs.getById(1l));
    }

    @Test
    void testGetAll() {
        List<Business> businesses = new ArrayList<>(){{
            Business b1 = new Business(1l,1729l,4569l,false,5l);
            Business b2 = new Business(2l,1736l,4259l,true,7l);
            Business b3 = new Business(3l,1528l,3256l,false,6l);
            Business b4 = new Business(4l,2629l,5896l,true,1l);
            Business b5 = new Business(5l,1635l,2145l,false,27l);
        }};
        Mockito.when(br.findAll()).thenReturn(businesses);
        Assertions.assertEquals(businesses,bs.getAll());
    }

    @Test
    void testUpdate() {
        Business b1 = new Business(1l,1729l,4569l,false,5l);
        Business b2 = new Business(1l,1729l,4569l,true,5l);
        Mockito.when(br.save(b1)).thenReturn(b2);
        Assertions.assertEquals(b2,bs.update(b1));
    }

    @Test
    void testDelete() {
        Mockito.when(br.existsById(1l)).thenReturn(true);
        Mockito.when(br.existsById(2l)).thenReturn(false);
        Assertions.assertTrue(bs.delete(1l));
        Assertions.assertFalse(bs.delete(2l));
    }

}
