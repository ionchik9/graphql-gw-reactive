package com.ion.solutions.customer.controller;

import com.ion.solutions.customer.model.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/v1/customers")
public class CustomersController {

    @GetMapping
    public List<Customer> getCustomersList(){
        var customers = new ArrayList<Customer>();
        for(var customerNo = 1; customerNo < Math.random() *100; customerNo++){
            customers.add(new Customer(UUID.randomUUID(), "name" + customerNo));
        }
        return customers;
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable UUID id){
        return new Customer(id, "youFoundIt");
    }

    @PostMapping
    public Customer addNewCustomer(@RequestBody String name){
        return new Customer(UUID.randomUUID(), name);
    }

}
