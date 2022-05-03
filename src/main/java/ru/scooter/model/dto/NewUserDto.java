package ru.scooter.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;
import org.apache.commons.lang3.RandomStringUtils;

@Data
@Accessors(fluent = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NewUserDto {

    @JsonProperty("firstName")
    String firstName;

    @JsonProperty("password")
    String password;

    @JsonProperty("login")
    String login;

    public NewUserDto(String firstName, String password, String login) {
        this.firstName = firstName;
        this.password = password;
        this.login = login;
    }

    public NewUserDto() {
    }

    public static NewUserDto getRandom() {
        String login = "auto" + RandomStringUtils.randomAlphabetic(10);
        String password = RandomStringUtils.randomAlphabetic(10);
        String firstName = "auto" + RandomStringUtils.randomAlphabetic(10);

        return new NewUserDto(firstName, password, login);
    }
}