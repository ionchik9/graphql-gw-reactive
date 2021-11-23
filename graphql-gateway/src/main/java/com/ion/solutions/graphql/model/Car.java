package com.ion.solutions.graphql.model;

import java.util.UUID;

public record Car(UUID id, UUID customerId, String brand) {
}
