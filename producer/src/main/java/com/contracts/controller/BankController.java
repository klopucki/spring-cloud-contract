package com.contracts.controller;

import com.contracts.model.Bank;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/bank")
@Slf4j
public class BankController {

    @PostMapping
    public ResponseEntity<Bank> saveBankData(@RequestBody Bank bank) {

        bank.setEntityId(1l);

        return new ResponseEntity<>(bank, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Bank> update(@RequestBody Bank bank) {
        log.info(bank.toString());

        bank.setEntityId(1l);

        return new ResponseEntity<>(bank, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Bank> get(@RequestParam("id") Long id) {
        Bank bank = new Bank(
                id,
                1l,
                "Watykańska"
        );

        return new ResponseEntity<>(bank, HttpStatus.OK);
    }

    @DeleteMapping(produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<?> delete(@RequestParam("id") Long id) {

        log.info("delete bank entity {}", id);
        return ResponseEntity.ok().body(id.toString());
    }
}
