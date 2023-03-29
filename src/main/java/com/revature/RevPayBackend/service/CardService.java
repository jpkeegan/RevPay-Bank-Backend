package com.revature.RevPayBackend.service;
import com.revature.RevPayBackend.entity.Card;
import com.revature.RevPayBackend.exceptions.IdNotFoundException;

import java.util.List;

public interface CardService {
    Card insert(Card card);
    List<Card> getAll();
    Card getById(Long account_id) throws IdNotFoundException;
    Card update(Card card) throws IdNotFoundException;
    boolean delete(Long account_id);
}
