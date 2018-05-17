package com.contracts;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureStubRunner(ids = "com.contracts:app1:+:stubs:8080", workOffline = true)
public class App2ApplicationTests {

    @Autowired
    private LibraryRemoteRestRepository remoteRepository;

    @Test
    public void shouldGetOneDefaultBook() throws Exception {
        Book book = remoteRepository.getAllBook();

        assertThat(book).isNotNull();
        assertThat(book.getAuthor()).isEqualTo("J. K. Rowling");
        assertThat(book.getTitle()).isEqualTo("Harry Potter");
        assertThat(book.getISBN()).isEqualTo("XXX");
    }

}
