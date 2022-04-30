package ru.scooter.assertions;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;
import ru.scooter.conditions.Condition;

@RequiredArgsConstructor
public class AssertableResponse {

    private final Response response;


    @Step("Проверка")
    public AssertableResponse shouldHave(Condition condition) {
        condition.check(response);
        return this;
    }

    public <T> T asPojo(Class<T> tClass) {
        T res = response.as(tClass);
        return res;
    }
}