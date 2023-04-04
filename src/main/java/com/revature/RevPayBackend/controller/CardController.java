package com.revature.RevPayBackend.controller;

import com.revature.RevPayBackend.dto.Origin;
import com.revature.RevPayBackend.entity.Transaction;
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
@CrossOrigin(origins = {Origin.origin,Origin.localhost})

public class CardController {
    @Autowired
    CardService cardService;

    @GetMapping("/{Id}")
    public ResponseEntity<Card> getById(@PathVariable("Id") Long cardId) throws IdNotFoundException {
        Card card = cardService.getById(cardId);
        return ResponseEntity.ok(card);
    }
//    @GetMapping("/account/{accountIdentifier}")
//    public ResponseEntity <List<Card>> getAllByAccountId(@PathVariable("accountIdentifier") String identifier){
//        try {
//            Long id = Long.parseLong(identifier);
//            return ResponseEntity.ok(cardService.getAllByAccountId(id));
//        } catch(Exception e) {
//            return ResponseEntity.status(404).build();
//
//        }
//    }

    @GetMapping("/account/{accountIdentifier}")
    public ResponseEntity<List<Card>> getAllByAccountId(@PathVariable("accountIdentifier") String identifier) {
        try {
            Long id = Long.parseLong(identifier);
            return ResponseEntity.ok(cardService.getAllCardsByAccountId(id));
        } catch(Exception e) {
            return ResponseEntity.status(404).build();
        }
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


    @DeleteMapping("/{cardId}")
    public ResponseEntity<Void> delete(@PathVariable Long cardId) {
        boolean deleted = cardService.delete(cardId);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}


