package ru.scooter;

import com.github.javafaker.Faker;
import io.qameta.allure.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.scooter.model.dto.OrderDto;
import ru.scooter.services.RequestService;

import java.time.LocalDate;
import java.util.*;

import static org.hamcrest.CoreMatchers.notNullValue;
import static ru.scooter.conditions.Conditions.bodyField;
import static ru.scooter.conditions.Conditions.statusCode;


@Epic(value = "Проверка API 'Самокат'")
@Feature(value = "Создание заказа")
@RunWith(Parameterized.class)
public class CreateOrderTest extends BaseTest {

    private final RequestService apiService = new RequestService();
    private static final Faker fakerRu = new Faker(new Locale("ru"));
    private final List<String> color;

    public CreateOrderTest(List<String> color) {
        this.color = color;
    }


    @Parameterized.Parameters
    public static Object[] getData() {
        return new Object[]{
                List.of(),
                List.of(fakerRu.color().name()),
                List.of(fakerRu.color().name(), fakerRu.color().name()),
        };
    }

    @Test
    @Story(value = "Успешный заказ")
    @Severity(SeverityLevel.CRITICAL)
    public void successOrderTest() {
        // given
        OrderDto order = new OrderDto()
                .firstName(fakerRu.name().firstName())
                .lastName(fakerRu.name().lastName())
                .address(fakerRu.address().fullAddress())
                .metroStation(fakerRu.number().numberBetween(1, 10))
                .phone(fakerRu.phoneNumber().phoneNumber())
                .rentTime(fakerRu.number().numberBetween(1, 10))
                .deliveryDate(LocalDate.now().toString())
                .comment(fakerRu.chuckNorris().fact())
                .color(color);

        // expect
        apiService.createOrder(order)
                .shouldHave(statusCode(201))
                .shouldHave(bodyField("track", notNullValue()));
    }
}