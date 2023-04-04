package com.revature.RevPayBackend.service;

import com.revature.RevPayBackend.entity.Card;
import com.revature.RevPayBackend.entity.Transaction;
import com.revature.RevPayBackend.repository.CardRepo;
import com.revature.RevPayBackend.exceptions.IdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CardServiceImpl implements CardService{
    @Autowired
    CardRepo cardRepo;
    @Override
    public Card insert(Card card) {
        return cardRepo.save(card);
    }

    @Override
    public List<Card> getAll() {
        return cardRepo.findAll();
    }

    @Override
    public Card getById(Long card_id) throws IdNotFoundException {
        if(!cardRepo.existsById(card_id)) throw new IdNotFoundException();
        return cardRepo.findById(card_id).get();
    }

    @Override
    public Card update(Card card)throws IdNotFoundException{
       if(!cardRepo.existsById(card.getCardId())) throw new IdNotFoundException();
       return cardRepo.save(card);
   }
    @Override
    public boolean delete(Long card_id) {
        boolean found = cardRepo.existsById(card_id);
        if(found){ cardRepo.deleteById(card_id);}
        return found;
    }

    public List<Card> getAllCardsByAccountId(Long accountId) {
        List<Card> cards = cardRepo.findAllByAccountId(accountId);
        return cards;
    }

//    @Override
//    public List<Card> getCardsByAccountId(Long accountId) {
//        return cardRepo.findByUserAccountId(accountId);
//    }

}

