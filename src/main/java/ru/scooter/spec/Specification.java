package ru.scooter.spec;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Specification {

    public static <T> RequestSpecification reqSpec(T body) {
        return new RequestSpecBuilder()
                .setAccept(ContentType.JSON)
                .setBody(body)
                .build();
    }
}