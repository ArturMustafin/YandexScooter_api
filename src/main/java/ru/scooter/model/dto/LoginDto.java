package ru.scooter.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;
import org.apache.commons.lang3.RandomStringUtils;

@Data
@Accessors(fluent = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoginDto {

    @JsonProperty("password")
    String password;

    @JsonProperty("login")
    String login;


    public LoginDto() {
    }

    public LoginDto(String password, String login) {
        this.password = password;
        this.login = login;
    }

    public LoginDto(NewUserDto user) {
        this.password = user.password();
        this.login = user.login();
    }

    public static LoginDto from(NewUserDto user) {
        return new LoginDto(user);
    }

    public static LoginDto getRandom() {
        String login = "auto" + RandomStringUtils.randomAlphabetic(10);
        String password = RandomStringUtils.randomAlphabetic(10);

        return new LoginDto(password, login);
    }
}