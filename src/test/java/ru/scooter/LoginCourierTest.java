package ru.scooter;

import io.qameta.allure.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import ru.scooter.model.dto.LoginDto;
import ru.scooter.model.dto.NewUserDto;
import ru.scooter.services.RequestService;

import static org.hamcrest.CoreMatchers.*;
import static ru.scooter.conditions.Conditions.bodyField;
import static ru.scooter.conditions.Conditions.statusCode;


@Epic(value = "Проверка API 'Самокат'")
@Feature(value = "Логин курьера")
public class LoginCourierTest extends BaseTest {

    private final RequestService apiService = new RequestService();


    @Test
    @Story(value = "Успешная авторизация курьера")
    @Severity(SeverityLevel.CRITICAL)
    public void successRegistrationUserTest() {
        // given
        NewUserDto newUser = new NewUserDto()
                .login("auto" + RandomStringUtils.randomAlphabetic(7))
                .password("" + RandomStringUtils.randomAlphabetic(5))
                .firstName("name" + RandomStringUtils.randomAlphabetic(7));

        LoginDto login = new LoginDto()
                .login(newUser.login())
                .password(newUser.password());
        // Creation User
        apiService.creationUser(newUser).shouldHave(statusCode(201));

        // expect
        apiService.loginUser(login)
                .shouldHave(statusCode(200))
                .shouldHave(bodyField("id", notNullValue()));
    }


    @Test
    @Story(value = "Нет обязательного поля 'login'")
    @Severity(SeverityLevel.NORMAL)
    public void loginUserNotRequiredFieldLoginTest() {
        // given
        LoginDto login = new LoginDto()
                .password("" + RandomStringUtils.randomAlphabetic(5));

        // expect
        apiService.loginUser(login)
                .shouldHave(statusCode(400))
                .shouldHave(bodyField("message", is("Недостаточно данных для входа")));
    }


    @Test
    @Story(value = "Нет обязательного поля 'password', 504 Gateway time out")
    @Severity(SeverityLevel.NORMAL)
    public void loginUserNotRequiredFieldPasswordTest() {
        // given
        LoginDto login = new LoginDto()
                .login("auto" + RandomStringUtils.randomAlphabetic(5));

        // expect
        apiService.loginUser(login)
                    .shouldHave(statusCode(504));
    }


    @Test
    @Story(value = "Невалидный логин и пароль")
    @Severity(SeverityLevel.NORMAL)
    public void incorrectLoginAndPasswordTest() {
        // given
        LoginDto login = new LoginDto()
                .login("auto" + RandomStringUtils.randomAlphabetic(7))
                .password("" + RandomStringUtils.randomAlphabetic(5));

        // expect
        apiService.loginUser(login)
                .shouldHave(statusCode(404))
                .shouldHave(bodyField("message", is("Учетная запись не найдена")));
    }


    @Test
    @Story(value = "Проверка существующего логина(успешно созданного пользователя) с некорректным паролем")
    @Severity(SeverityLevel.NORMAL)
    public void incorrectPasswordTest() {
        // given
        NewUserDto newUser = new NewUserDto()
                .login("auto" + RandomStringUtils.randomAlphabetic(7))
                .password("" + RandomStringUtils.randomAlphabetic(5))
                .firstName("name" + RandomStringUtils.randomAlphabetic(7));

        LoginDto login = new LoginDto()
                .login(newUser.login())
                .password("" + RandomStringUtils.randomAlphabetic(5));

        // Creation User
        apiService.creationUser(newUser).shouldHave(statusCode(201));

        // expect
        apiService.loginUser(login)
                .shouldHave(statusCode(404))
                .shouldHave(bodyField("message", is("Учетная запись не найдена")));
    }


    @Test
    @Story(value = "Проверка существующего пароля(успешно созданного пользователя) с некорректным логином")
    @Severity(SeverityLevel.NORMAL)
    public void incorrectLoginTest() {
        // given
        NewUserDto newUser = new NewUserDto()
                .login("auto" + RandomStringUtils.randomAlphabetic(7))
                .password("" + RandomStringUtils.randomAlphabetic(5))
                .firstName("name" + RandomStringUtils.randomAlphabetic(7));

        LoginDto login = new LoginDto()
                .login("" + RandomStringUtils.randomAlphabetic(5))
                .password(newUser.password());

        // Creation User
        apiService.creationUser(newUser).shouldHave(statusCode(201));

        // expect
        apiService.loginUser(login)
                .shouldHave(statusCode(404))
                .shouldHave(bodyField("message", is("Учетная запись не найдена")));
    }
}