package com.ion.solutions.graphql.client.impl;

import com.ion.solutions.graphql.client.CarsClient;
import com.ion.solutions.graphql.config.WebClientConfig;
import com.ion.solutions.graphql.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import javax.annotation.PostConstruct;
import java.util.UUID;

@Service
public class CarsClientImpl implements CarsClient {
    @Autowired
    private WebClientConfig clientConfig;
    private WebClient webClient;

    @PostConstruct
    public void init(){
        webClient = WebClient.builder()
                .baseUrl(clientConfig.getCarsClientUrl())
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    @Override
    public Flux<Car> getCustomersCarsList(UUID customerId) {
        return webClient
                .get()
                .uri("/api/v1/cars?customer={id}", customerId)
                .retrieve()
                .bodyToFlux(Car.class);
    }
}
