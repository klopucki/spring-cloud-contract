package com.contracts.controller;

import com.contracts.model.Book;
import com.contracts.service.LibraryService;
import com.google.common.collect.Lists;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/library")
@Slf4j
@NoArgsConstructor
public class LibraryController {

    private LibraryService libraryService;

    @Autowired
    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.status(201).body(libraryService.findBooks());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Book> saveBook(@RequestBody Book book) {
        log.info(book.getTitle());
        Book savedBook = libraryService.save(book);

        return new ResponseEntity<>(savedBook, HttpStatus.OK);
    }

}
