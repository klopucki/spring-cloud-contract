package com.contracts;

import com.contracts.controller.BankController;
import com.contracts.controller.GreetingController;
import com.contracts.controller.LibraryController;
import com.contracts.model.Book;
import com.contracts.service.LibraryService;
import com.google.common.collect.ImmutableList;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@DirtiesContext
@AutoConfigureMessageVerifier
public abstract class BaseTestClass {

    @Mock
    LibraryService libraryService;
    @InjectMocks
    LibraryController libraryController;

    @Before
    public void setup() {
        Book bookToSave = mockGFBook();
        BDDMockito.given(libraryService.findBooks()).willReturn(ImmutableList.of(mockBook()));
        BDDMockito.given(libraryService.save(bookToSave)).willReturn(bookToSave);

        RestAssuredMockMvc.standaloneSetup(
                BankController.class, GreetingController.class, libraryController);
    }

    private Book mockGFBook(){
        return new Book("God Father", "Mario Puzo", "XX5");
    }

    private Book mockBook() {
        return new Book("Harry Potter", "J. K. Rowling", "XXX");
    }
}
