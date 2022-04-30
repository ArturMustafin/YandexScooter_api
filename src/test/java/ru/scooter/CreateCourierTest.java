package ru.scooter;

import io.qameta.allure.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import ru.scooter.model.dto.NewUserDto;
import ru.scooter.services.RequestService;

import static org.hamcrest.CoreMatchers.is;
import static ru.scooter.conditions.Conditions.bodyField;
import static ru.scooter.conditions.Conditions.statusCode;

@Epic(value = "Проверка API 'Самокат'")
@Feature(value = "Создание курьера")
public class CreateCourierTest extends BaseTest {

    private final RequestService apiService = new RequestService();

    @Test
    @Story(value = "Успешная регистрация курьера")
    @Severity(SeverityLevel.CRITICAL)
    public void successRegistrationUserTest() {
        // given
        NewUserDto newUser = new NewUserDto()
                .login("auto" + RandomStringUtils.randomAlphabetic(7))
                .password("" + RandomStringUtils.randomAlphabetic(5))
                .firstName("name" + RandomStringUtils.randomAlphabetic(7));

        // expect
        apiService.creationUser(newUser)
                .shouldHave(statusCode(201))
                .shouldHave(bodyField("ok", is(true)));
    }


    @Test
    @Story(value = "Нет обязательного поля")
    @Severity(SeverityLevel.NORMAL)
    public void userRegistrationNotRequiredFieldsTest() {
        // given
        NewUserDto newUser = new NewUserDto()
                .login("auto" + RandomStringUtils.randomAlphabetic(7))
                .firstName("name" + RandomStringUtils.randomAlphabetic(7));

        // expect
        apiService.creationUser(newUser)
                .shouldHave(statusCode(400))
                .shouldHave(bodyField("message", is("Недостаточно данных для создания учетной записи")));
    }


    @Test
    @Story(value = "Нельзя создать двух одинаковых курьеров")
    @Severity(SeverityLevel.MINOR)
    public void cannotCreateDoubleUserTest() {
        // given
        NewUserDto newUser = new NewUserDto()
                .login("auto" + RandomStringUtils.randomAlphabetic(7))
                .password("" + RandomStringUtils.randomAlphabetic(5))
                .firstName("name" + RandomStringUtils.randomAlphabetic(7));

        // Create user
        apiService.creationUser(newUser)
                .shouldHave(statusCode(201));

        // expect
        apiService.creationUser(newUser)
                .shouldHave(statusCode(409))
                .shouldHave(bodyField("message", is("Этот логин уже используется. Попробуйте другой.")));
    }
}