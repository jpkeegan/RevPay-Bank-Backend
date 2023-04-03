package com.revature.RevPayBackend.service;
import com.revature.RevPayBackend.entity.Card;
import com.revature.RevPayBackend.repository.CardRepo;
import com.revature.RevPayBackend.exceptions.IdNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
//@TestPropertySource("classpath:test.properties")
public class CardServiceTest {
    @MockBean(CardRepo.class)
    private  CardRepo cardRepo;
    @Autowired
    CardService cardService;

    @Test
    public void testInsert(){
        Card card1 = new Card(-1l,2l,8l,false);
        Card card2 = new Card(1l,2l,8l,true);
        Mockito.when(cardRepo.save(card1)).thenReturn(card2);
        Assertions.assertEquals(card2, cardService.insert(card1));
    }

    @Test
    public void testUpdate() throws IdNotFoundException{
        Card card1 = new Card(1l,3l,3l,true);
        Card card2 = new Card(1l,5l,3l,true);
        Mockito.when(cardRepo.save(card1)).thenReturn(card2);
        Assertions.assertEquals(card2,cardService.insert(card1));
    }

    @Test
     public void testGetAll(){
    List<Card> cards = new ArrayList<>(){{
        Card card1 = new Card(2l,3l,2l,false);
        Card card2 = new Card(2l,2l,3l,true);

    }};
        Mockito.when(cardRepo.findAll()).thenReturn(cards);
        Assertions.assertEquals(cards,cardService.getAll());
}
    @Test
    public void testGetById() throws IdNotFoundException{
        Card c1 = new Card(3l,4l,5l,true);
        Mockito.when(cardRepo.findById(3l)).thenReturn(Optional.of(c1));
        Mockito.when(cardRepo.existsById(3l)).thenReturn(true);
        Assertions.assertEquals(c1,cardService.getById(3l));
    }
    @Test
    public void testDelete(){
        Mockito.when(cardRepo.existsById((long)2)).thenReturn(true);
        Mockito.when(cardRepo.existsById((long)3)).thenReturn(false);
        Assertions.assertTrue(cardService.delete((long)2));
        Assertions.assertFalse(cardService.delete((long)3));
    }

}
