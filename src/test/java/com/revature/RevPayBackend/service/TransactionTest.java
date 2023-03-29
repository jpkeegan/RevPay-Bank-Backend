package com.revature.RevPayBackend.service;

import com.revature.RevPayBackend.entity.Transaction;
import com.revature.RevPayBackend.repository.TransactionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

// Make sure we have this @SpringBootTest annotation at the top of our test classes
@SpringBootTest
//@TestPropertySource("classpath:test.properties")
public class TransactionTest {

    // mock the pet repository bean, pass in the interface/class that we're mocking:
    @MockBean(TransactionRepository.class)
    private TransactionRepository transactionRepository;

    // Autowire the PetService, so we have an instance of the petService to test out
    @Autowired TransactionService transactionService;

    @Test
    public void testInsert() {
        // initialize a pet to insert:
        Transaction transaction = new Transaction(42, true, 777, "asd@yahoo.com", 345);
        // creating the expected pet object once it is inserted and an id is generated:
        // The value 2 here is completely arbitrary, it's just so we have an actual id that is "generated" from the mocked save method
        Transaction insertedTransaction = new Transaction(1L,42, true, 777, "asd@yahoo.com", 345);

        // mock the save method of the repository, so the repository doesn't actually access the database
        // whenever the .save method is called, it will return the pet object that we created in this test case
        Mockito.when(transactionRepository.save(transaction)).thenReturn(insertedTransaction);

        // ensure that the service returns the updated pet:
        Assertions.assertEquals(insertedTransaction, transactionService.insert(transaction));

    }

    @Test
    public void testGetById() {
        Transaction expectedTransaction = new Transaction(42, true, 777, "asd@yahoo.com", 345);
        // because findById returns an optional, we have to create a mock optional:
        Optional<Transaction> userOptional = Optional.of(expectedTransaction);
        // So now when we call the findById method it will return an optional of the pet that we created
        Mockito.when(transactionRepository.findById(1L)).thenReturn(userOptional);

        // Finally, call the petService method and assert that the pet we get is the one that we specified using Mocking
        Assertions.assertEquals(expectedTransaction, transactionService.getById(1L));
    }


    @Test
    public void testGetAll() {
        List<Transaction> appUsers = Arrays.asList(
                new Transaction(43, false, 776, "asd@yahoo.com", 345),
                new Transaction(42, true, 777, "asd@yahoo.com", 345)
        );

        Mockito.when(transactionRepository.findAll()).thenReturn(appUsers);

        // Finally, call the petService method and assert that the pet we get is the one that we specified using Mocking
        Assertions.assertEquals(appUsers, transactionService.getAll());
    }

    @Test
    public void testUpdate() {

        Transaction transaction = new Transaction(1L,43, false, 776, "asd@yahoo.com", 345);
        Transaction updatedTransaction = new Transaction(2L,42, true, 777, "asd@yahoo.com", 345);

        Mockito.when(transactionRepository.save(transaction)).thenReturn(updatedTransaction);

        Assertions.assertEquals(updatedTransaction, transactionService.update(transaction));
    }

    @Test
    public void testDelete() {

        Transaction transaction = new Transaction(43L, false, 776, "asd@yahoo.com", 345);


        Mockito.when(transactionRepository.existsById(43L)).thenReturn(true);

        transactionService.delete(43L);
        Mockito.verify(transactionRepository).deleteById(43L);
    }
}