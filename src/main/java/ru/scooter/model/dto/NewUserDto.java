package ru.scooter.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

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
}