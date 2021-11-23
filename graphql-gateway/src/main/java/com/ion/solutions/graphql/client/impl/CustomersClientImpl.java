package com.ion.solutions.graphql.client.impl;


import com.ion.solutions.graphql.config.WebClientConfig;
import com.ion.solutions.graphql.model.Customer;
import lombok.extern.slf4j.Slf4j;
import com.ion.solutions.graphql.client.CustomersClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.UUID;

@Service
@Slf4j
public class CustomersClientImpl implements CustomersClient {
    @Autowired
    private WebClientConfig clientConfig;
    private WebClient webClient;

    @PostConstruct
    public void init(){
        webClient = WebClient.builder()
                .baseUrl(clientConfig.getCustomersClientUrl())
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }


    @Override
    public Flux<Customer> getCustomersList() {
        return webClient
                .get()
                .uri("/api/v1/customers")
                .retrieve()
                .bodyToFlux(Customer.class);
    }

    @Override
    public Mono<Customer> getCustomerById(UUID id) {
        return webClient
                .get()
                .uri("/api/v1/customers/{id}", id)
                .retrieve()
                .bodyToMono(Customer.class);
    }

    @Override
    public Mono<Customer> addCustomer(String name) {
        return webClient
                .post()
                .uri("/api/v1/customers")
                .body(Mono.just(name), String.class)
                .retrieve()
                .bodyToMono(Customer.class);
    }

}
