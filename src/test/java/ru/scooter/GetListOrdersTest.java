package ru.scooter;

import io.qameta.allure.*;
import org.junit.Test;
import ru.scooter.services.RequestService;

import static org.hamcrest.CoreMatchers.notNullValue;
import static ru.scooter.conditions.Conditions.bodyField;
import static ru.scooter.conditions.Conditions.statusCode;


@Epic(value = "Проверка API 'Самокат'")
@Feature(value = "Список заказов")
public class GetListOrdersTest extends BaseTest {

    private final RequestService apiService = new RequestService();

    @Test
    @Story(value = "Успешно возвращается список заказов")
    @Severity(SeverityLevel.CRITICAL)
    public void successReturnListOrdersTest() {

        apiService.getOrders()
                .shouldHave(statusCode(200))
                .shouldHave(bodyField("orders.id", notNullValue()));
    }
}