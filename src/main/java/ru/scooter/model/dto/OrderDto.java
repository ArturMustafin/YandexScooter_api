package ru.scooter.model.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

@Data
@Accessors(fluent = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderDto {

    @JsonProperty("firstName")
    String firstName;

    @JsonProperty("lastName")
    String lastName;

    @JsonProperty("address")
    String address;

    @JsonProperty("color")
    List<String> color;

    @JsonProperty("phone")
    String phone;

    @JsonProperty("comment")
    String comment;

    @JsonProperty("rentTime")
    int rentTime;

    @JsonProperty("deliveryDate")
    String deliveryDate;

    @JsonProperty("metroStation")
    int metroStation;
}