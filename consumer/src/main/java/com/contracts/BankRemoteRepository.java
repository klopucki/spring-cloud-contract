package com.contracts;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URISyntaxException;

@Repository
@Slf4j
public class BankRemoteRepository {

    private static final String URL = "http://localhost:8080/bank";

    @Autowired
    private ObjectMapper objectMapper;

    public Bank postData() throws IOException, URISyntaxException {

        Bank bank = provideBankData();

        HttpEntity<Bank> httpEntity = getBankHttpEntity(bank);
        RestTemplate restTemplate = new RestTemplate();

        String response = restTemplate.postForObject(URL, httpEntity, String.class);

        return objectMapper.readValue(response, Bank.class);
    }

    public Bank putData() {
        Bank bank = provideBankData();
        HttpEntity<Bank> httpEntity = getBankHttpEntity(bank);

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Bank> response = restTemplate.exchange(URL, HttpMethod.PUT, httpEntity, Bank.class);

        return response.getBody();
    }

    public Bank getData() {
        UriComponentsBuilder builder = UriComponentsBuilder
                .fromUriString(URL)
                .queryParam("id", "100");

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Content-Type", "application/json");

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Bank> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, new HttpEntity<>(httpHeaders), Bank.class);

        return response.getBody();
    }

    public Long deleteData() {

        UriComponentsBuilder builder = UriComponentsBuilder
                .fromUriString(URL)
                .queryParam("id", "100");

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Content-Type", "application/json");

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> response = restTemplate.exchange(builder.toUriString(), HttpMethod.DELETE, new HttpEntity<>(httpHeaders), String.class);

        return Long.parseLong(response.getBody());
    }


    private HttpEntity<Bank> getBankHttpEntity(Bank bank) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Content-Type", "application/json");

        return new HttpEntity<>(bank, httpHeaders);
    }

    private Bank provideBankData() {
        Bank bankRequest = new Bank();
        bankRequest.setAccountId(1l);
        bankRequest.setAddress("Wojciechowska 5");

        return bankRequest;
    }
}
