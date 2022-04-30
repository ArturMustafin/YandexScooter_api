package ru.scooter.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

@Data
@Accessors(fluent = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoginDto {

    @JsonProperty("password")
    String password;

    @JsonProperty("login")
    String login;
}