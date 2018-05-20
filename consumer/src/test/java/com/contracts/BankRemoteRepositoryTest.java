package com.contracts;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureStubRunner(ids = "com.contracts:producer:+:stubs:8080", workOffline = true)
public class BankRemoteRepositoryTest {

    @Autowired
    private BankRemoteRepository bankRemoteRepository;

    @Test
    public void remoteBankRepoPOST() throws IOException, URISyntaxException {
        Bank bank = bankRemoteRepository.postData();

        assertThat(bank.getAccountId()).isEqualTo(1l);
        assertThat(bank.getAddress()).isEqualTo("Wojciechowska 5");
    }

    @Test
    public void remoteBankRepoPUT() {
        Bank bank = bankRemoteRepository.putData();

        assertThat(bank.getAccountId()).isEqualTo(1l);
        assertThat(bank.getAddress()).isEqualTo("Wojciechowska 5");
    }

    @Test
    public void remoteBankRepoGET() {
        Bank bank = bankRemoteRepository.getData();

        assertThat(bank.getAccountId()).isEqualTo(1l);
        assertThat(bank.getAddress()).isEqualTo("Watykańska");
    }

    @Test
    public void remoteBankRepoDELETE() {
        Long deletedId = bankRemoteRepository.deleteData();

        assertThat(deletedId).isEqualTo(100l);
    }
}
