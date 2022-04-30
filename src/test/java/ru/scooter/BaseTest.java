package ru.scooter;

import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.junit.Before;

public class BaseTest {

    @Before
    public void setUp() {
        ProjectConfig config = ConfigFactory.create(ProjectConfig.class);
        RestAssured.baseURI = config.baseUrl();
    }
}