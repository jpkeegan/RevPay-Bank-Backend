package com.revature.RevPayBackend.service;

import com.revature.RevPayBackend.entity.Card;
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
    public Card getById(Long account_id) throws IdNotFoundException {
        if(!cardRepo.existsById(account_id)) throw new IdNotFoundException();
        return cardRepo.findById(account_id).get();
    }


    @Override
    public Card update(Card card)throws IdNotFoundException{
        if(!cardRepo.existsById(card.getAccountId())) throw new IdNotFoundException();
        return cardRepo.save(card);
    }
    @Override
    public boolean delete(Long account_id) {
        boolean found = cardRepo.existsById(account_id);
        if(found){ cardRepo.deleteById(account_id);}
        return found;
    }


//    @Override
//    public Card updateCard(long cardNumber, long accountId, boolean isCredit) {
//        Card card = cardRepo.findById(cardNumber)
//                .orElseThrow(() -> new NoSuchElementException("Card not found with number: " + cardNumber));
//        card.setAccountId(accountId);
//        card.setCredit(isCredit);
//        return cardRepo.save(card);
//    }

}
