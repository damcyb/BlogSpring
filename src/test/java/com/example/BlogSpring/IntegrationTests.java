package com.example.BlogSpring;

import com.example.BlogSpring.constants.Constants;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationTests {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void pageConnectionStatusShouldBeOk() {
        System.out.println(">> Assert blog status code");
        ResponseEntity<String> entity = restTemplate.getForEntity(Constants.USER_PATH, String.class);
        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(entity.getBody()).isEqualTo("Hello world!");
    }
}
