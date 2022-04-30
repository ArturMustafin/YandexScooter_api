package ru.scooter.services;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PUBLIC)
public class EndPoints {
    static final String CREATE_COURIER = "/api/v1/courier";
    static final String LOGIN = "/api/v1/courier/login";
    static final String ORDER = "/api/v1/orders";
}