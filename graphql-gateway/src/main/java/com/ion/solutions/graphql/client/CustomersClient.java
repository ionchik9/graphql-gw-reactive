package com.ion.solutions.graphql.client;

import com.ion.solutions.graphql.model.Customer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface CustomersClient {
    Flux<Customer> getCustomersList();
    Mono<Customer> getCustomerById(UUID id);
    Mono<Customer> addCustomer(String name);
}
