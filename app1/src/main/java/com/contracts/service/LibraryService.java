package com.contracts.service;

import com.contracts.model.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class LibraryService {

    private List<Book> library = new ArrayList<>();

    public LibraryService() {
        library.add(new Book("Harry Potter", "J. K. Rowling", "XXX"));
    }

    public List<Book> findBooks() {
        log.info("SUPER TEST");
        library.forEach(x -> log.info(x.toString()));
        return library;
    }

    public Book save(@Valid Book book) {
        library.add(book);
        return book;
    }
}
