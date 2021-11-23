package com.ion.solutions.car.controller;

import com.ion.solutions.car.model.Car;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/v1/cars")
public class CarsController {

    @GetMapping
    public List<Car>getCustomersCars(@RequestParam("customer") UUID customerId){
        var carsList = new ArrayList<Car>();
        for(var carNo = 1; carNo < Math.random() *100; carNo++){
            carsList.add(new Car(UUID.randomUUID(), customerId, "brand" + carNo));
        }
        return carsList;
    }
}
