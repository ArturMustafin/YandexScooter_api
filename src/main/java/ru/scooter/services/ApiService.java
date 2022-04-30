package ru.scooter.services;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class ApiService {

    protected RequestSpecification setup() {
        return RestAssured
                .given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .when();
    }
}