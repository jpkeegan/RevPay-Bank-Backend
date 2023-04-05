package com.revature.RevPayBackend.service;

import com.revature.RevPayBackend.dto.LoginForm;
import com.revature.RevPayBackend.dto.UserAccountReturnInfo;
import com.revature.RevPayBackend.entity.Business;
import com.revature.RevPayBackend.entity.UserAccount;
import com.revature.RevPayBackend.exceptions.UserExceptions.IdNotFoundException;
import com.revature.RevPayBackend.exceptions.UserExceptions.UserNotFoundException;
import com.revature.RevPayBackend.exceptions.UserExceptions.UsernameNotFoundException;
import com.revature.RevPayBackend.repository.UserAccountRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.revature.RevPayBackend.entity.UserAccount.hashPassUA;

@SpringBootTest
public class UserAccountServiceTest {
    @MockBean(UserAccountRepository.class)
    private UserAccountRepository userAccountRepository;

    @Autowired
    UserAccountServiceImpl userAccountService;

    @Test
    void testInsert(){
        UserAccount newUser = new UserAccount("testUser","pass12345","testemail@email.com",8888888888l,"Test User","123 Test Place",false);
        UserAccount returnUser = new UserAccount(1l,"testUser","pass12345","testemail@email.com",8888888888l,"Test User","123 Test Place",false);
        hashPassUA(returnUser);
        Mockito.when(userAccountRepository.save(newUser)).thenReturn(returnUser);
        Assertions.assertEquals(returnUser,userAccountService.insert(newUser));
    }

    @Test
    void testUpdate(){
        UserAccount user1 = new UserAccount(1l,"testUser","pass12345","testemail@email.com",8888888888l,"Test User","123 Test Place",false);
        UserAccount user2 = new UserAccount(1l,"testUser","pass12345","testemail@email.com",8889991111l,"Test User","123 Test Place",false);
        Mockito.when(userAccountRepository.save(user1)).thenReturn(user2);
        Assertions.assertEquals(user2,userAccountService.update(user1));
    }

    @Test
    void testDelete() throws IdNotFoundException {
        Mockito.when(userAccountRepository.existsById(1l)).thenReturn(true);
        Mockito.when(userAccountRepository.existsById(2l)).thenReturn(false);
        Assertions.assertTrue(userAccountService.delete(1l));
        Assertions.assertThrows(IdNotFoundException.class,()->userAccountService.delete(2l));
    }

    @Test
    void testGets() throws UsernameNotFoundException, IdNotFoundException {
        UserAccount user1 = new UserAccount(1l,"testUser1","pass12345","testemail1@email.com",8888881888l,"Test User1","123 Test Place",false);
        UserAccount user2 = new UserAccount(2l,"testUser2","pass12345","testemail2@email.com",8888882888l,"Test User2","124 Test Place",true);
        UserAccount user3 = new UserAccount(3l,"testUser3","pass12345","testemail3@email.com",8888883888l,"Test User3","125 Test Place",false);
        UserAccount user4 = new UserAccount(4l,"testUser4","pass12345","testemail4@email.com",8888884888l,"Test User4","126 Test Place",true);
        UserAccount user5 = new UserAccount(5l,"testUser5","pass12345","testemail5@email.com",8888885888l,"Test User5","127 Test Place",false);

        List<UserAccount> users = new ArrayList<>();
        List<UserAccount> businessUsers = new ArrayList<>();
        List<UserAccount> personalUsers = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        businessUsers.add(user2);
        businessUsers.add(user4);
        personalUsers.add(user5);
        personalUsers.add(user3);
        personalUsers.add(user1);

        Mockito.when(userAccountRepository.findAll()).thenReturn(users);
        Mockito.when(userAccountRepository.findByBusinessAccountTrue()).thenReturn(businessUsers);
        Mockito.when(userAccountRepository.findByBusinessAccountFalse()).thenReturn(personalUsers);
        Mockito.when(userAccountRepository.existsByUsername("testUser2")).thenReturn(true);
        Mockito.when(userAccountRepository.existsByUsername("NotArealtestUser2")).thenReturn(false);
        Mockito.when(userAccountRepository.existsById(4l)).thenReturn(true);
        Mockito.when(userAccountRepository.existsById(4333l)).thenReturn(false);
        Mockito.when(userAccountRepository.findById(4l)).thenReturn(Optional.of(user4));
        Mockito.when(userAccountRepository.findByUsername("testUser2")).thenReturn(user2);
        Assertions.assertEquals(users,userAccountService.getAll());
        Assertions.assertEquals(businessUsers,userAccountService.getAll(true));
        Assertions.assertEquals(personalUsers,userAccountService.getAll(false));
        Assertions.assertEquals(user4,userAccountService.getById(4l));
        Assertions.assertEquals(user2,userAccountService.getByUsername("testUser2"));
        Assertions.assertThrows(IdNotFoundException.class,()->userAccountService.getById(4333l));
        Assertions.assertThrows(UsernameNotFoundException.class,()->userAccountService.getByUsername("NotArealtestUser2"));

    }


    @Test
    void testVerifyLogin() throws UserNotFoundException {
        LoginForm user1 = new LoginForm("testUser","pass12345");
        LoginForm badLogin = new LoginForm("testUser","pass1234567");
        UserAccount user2 = new UserAccount(1l,"testUser","pass12345","testemail@email.com",8888888888l,"Test User","123 Test Place",false);

        Mockito.when(userAccountRepository.verifyLogin(user1.getUsername(),user2.getPassword())).thenReturn(user2);
        Mockito.when(userAccountRepository.verifyLogin(badLogin.getUsername(),badLogin.getPassword())).thenReturn(null);
        Assertions.assertEquals(user2,userAccountService.verify(user1));
        Assertions.assertThrows(UserNotFoundException.class,()->userAccountService.verify(badLogin));
    }




}
