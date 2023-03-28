package com.revature.RevPayBackend.controller;


import com.revature.RevPayBackend.entity.Business;
import com.revature.RevPayBackend.service.BusinessService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/businesses")
public class BusinessController {
    BusinessService businessService;

    @PostMapping()
    public ResponseEntity<Business> insert(@RequestBody Business business){
        return new ResponseEntity<>(businessService.insert(business), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Business> getById(@PathVariable("id") Long identifier){
        try {
            return new ResponseEntity<>(businessService.getById(identifier),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(new Business(),HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping()
    public ResponseEntity<Business> update(@RequestBody Business business){
        try{
            return new ResponseEntity<>(businessService.update(business),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(new Business(),HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{deleteId}")
    public boolean delete(@PathVariable("deleteId") Long id){
        return businessService.delete(id);
    }
}
