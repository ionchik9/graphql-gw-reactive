package com.ion.solutions.car.model;

import java.util.UUID;

public record Car(UUID id, UUID customerId, String brand) {
}
