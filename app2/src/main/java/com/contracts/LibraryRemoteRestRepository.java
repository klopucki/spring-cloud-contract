package com.contracts;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Repository
public class LibraryRemoteRestRepository {

    @Autowired
    private ObjectMapper objectMapper;

    public Book getAllBook() {
        final String uri = "http://localhost:8080/library";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, null, String.class);

        String resultString = response.getBody();
        HttpHeaders headers = response.getHeaders();

        Book book = null;
        try {
            book = objectMapper.readValue(resultString, Book.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(resultString);
        System.out.println(headers);
        return book;
    }
}
