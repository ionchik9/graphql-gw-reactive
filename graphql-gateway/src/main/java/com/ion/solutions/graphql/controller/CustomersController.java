package com.ion.solutions.graphql.controller;

import com.ion.solutions.graphql.client.CarsClient;
import com.ion.solutions.graphql.model.Car;
import com.ion.solutions.graphql.client.CustomersClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import com.ion.solutions.graphql.model.Customer;
import java.util.UUID;

@Controller
public class CustomersController {
    @Autowired
    private CustomersClient customersClient;
    @Autowired
    private CarsClient carsClient;


    @QueryMapping
    public Flux<Customer>customers(){
        return customersClient.getCustomersList();
    }

    @QueryMapping
    public Mono<Customer>findCustomerById(@Argument UUID id ){
        return customersClient.getCustomerById(id);
    }

    @MutationMapping
    public Mono<Customer> addCustomer(@Argument String name){
        return customersClient.addCustomer(name);
    }

    @SchemaMapping(typeName = "Customer")
    public Flux<Car> cars(Customer customer){
        return carsClient.getCustomersCarsList(customer.id());
    }
}
