package ru.scooter.services;

import io.qameta.allure.Step;
import ru.scooter.assertions.AssertableResponse;
import ru.scooter.model.dto.LoginDto;
import ru.scooter.model.dto.NewUserDto;
import ru.scooter.model.dto.OrderDto;

import static ru.scooter.spec.Specification.reqSpec;

public class RequestService extends ApiService {

    @Step("Send POST request to (/api/v1/courier)")
    public AssertableResponse creationUser(NewUserDto body) {
        return new AssertableResponse(setup()
                .spec(reqSpec(body))
                .post(EndPoints.CREATE_COURIER));
    }

    @Step("Send POST request to (/api/v1/courier/login)")
    public AssertableResponse loginUser(LoginDto body) {
        return new AssertableResponse(setup()
                .body(body)
                .post(EndPoints.LOGIN));
    }

    @Step("Send POST request to (/api/v1/orders)")
    public AssertableResponse createOrder(OrderDto body) {
        return new AssertableResponse(setup()
                .body(body)
                .post(EndPoints.ORDER));
    }

    @Step("Send GET request to (/api/v1/orders)")
    public AssertableResponse getOrders() {
        return new AssertableResponse(setup()
                .get(EndPoints.ORDER));
    }
}