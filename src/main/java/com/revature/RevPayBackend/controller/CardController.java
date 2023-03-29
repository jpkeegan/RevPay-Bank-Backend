package com.revature.RevPayBackend.controller;

import com.revature.RevPayBackend.service.CardService;
import com.revature.RevPayBackend.entity.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.revature.RevPayBackend.exceptions.IdNotFoundException;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.NoSuchElementException;
@RestController
@RequestMapping("/cards")
@CrossOrigin(origins = "*")

public class CardController {
    @Autowired
    CardService cardService;

    @GetMapping("/{accountId}")
    public ResponseEntity<Card> getById(@PathVariable("accountId") Long accountId) throws IdNotFoundException {
        Card card = cardService.getById(accountId);
        return ResponseEntity.ok(card);
    }
    @GetMapping()
    public List<Card> getAll(){
        return cardService.getAll();
    }


    @PostMapping()
    public ResponseEntity<Card> insert(@RequestBody Card card) {
        System.out.println(card);
        Card insertedCard = cardService.insert(card);
        return new ResponseEntity<Card>(insertedCard, HttpStatus.CREATED);
    }

    @PutMapping()
    public Card update(@RequestBody Card card)throws IdNotFoundException {
        return cardService.update(card);
    }


    @DeleteMapping("/{accountId}")
    public ResponseEntity<Void> delete(@PathVariable Long accountId) {
        boolean deleted = cardService.delete(accountId);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}


