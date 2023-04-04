package com.revature.RevPayBackend.daotest;


import com.revature.RevPayBackend.entity.Business;
import com.revature.RevPayBackend.repository.BusinessRepsository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.List;
import java.util.NoSuchElementException;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestBusinessRepository {
    @Autowired
    BusinessRepsository br;

    @BeforeAll
    public void setUp(){
        Business b1 = new Business(1l,1729l,4569l,false,5l);
        Business b2 = new Business(2l,1736l,4259l,true,7l);
        Business b3 = new Business(3l,1528l,3256l,false,6l);
        Business b4 = new Business(4l,2629l,5896l,true,1l);
        Business b5 = new Business(5l,1635l,2145l,false,27l);
        br.save(b1);
        br.save(b2);
        br.save(b3);
        br.save(b4);
        br.save(b5);
    }

    @Test
    void testNewBusiness(){
        Business nb = new Business();
        nb.setBin(32561l);
        nb.setEin(52723l);
        nb.setForProfit(false);
        nb.setAccountId(10l);
        nb = br.save(nb);
        Assertions.assertEquals(6,nb.getBusinessId());
        Assertions.assertEquals(32561,nb.getBin());
        Assertions.assertEquals(52723,nb.getEin());
        Assertions.assertEquals(10,nb.getAccountId());
        Assertions.assertEquals(false,nb.isForProfit());
    }

    @Test
    void testGetById(){
        //test exception thrown
        try {
            Business nb = br.findById(8l).get();
        }catch(NoSuchElementException e){
            Assertions.assertEquals(NoSuchElementException.class,e.getClass());
        }
        //test entity found
        try {
            Business nb = br.findById(1l).get();
            Assertions.assertEquals(1,nb.getBusinessId());
            Assertions.assertEquals(1729,nb.getBin());
            Assertions.assertEquals(4569,nb.getEin());
            Assertions.assertEquals(5,nb.getAccountId());
            Assertions.assertEquals(false,nb.isForProfit());
        }catch(NoSuchElementException e){
            Assertions.assertFalse(true);
        }
    }

    @Test
    void testGetAll(){
        List<Business> ba = br.findAll();
        Assertions.assertTrue(ba.size()>4);
    }

    @Test
    void testUpdate(){
        Business businessToUpdate = new Business(1l,1729l,4569l,true,5l);
        try{
            Assertions.assertEquals(true,br.save(businessToUpdate).isForProfit());
        }catch(Exception e){
            Assertions.assertFalse(true);
        }
    }

    @Test
    void testDelete(){
        //test delete by id
        br.deleteById(2l);
        Assertions.assertEquals(false,br.existsById(2l));
        //test no such entity exception
        try {
            br.deleteById(27l);
        }catch(EmptyResultDataAccessException e){
            Assertions.assertEquals(EmptyResultDataAccessException.class,e.getClass());
        }
    }
}
