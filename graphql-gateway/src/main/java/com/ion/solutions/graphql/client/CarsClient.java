package com.ion.solutions.graphql.client;

import com.ion.solutions.graphql.model.Car;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.UUID;

public interface CarsClient {
    Flux<Car> getCustomersCarsList(UUID customerId);
}
