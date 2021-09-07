package com.example.demo.model;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserDto {
    @NotNull(message = "Name Should not be null")
    private String name;
    @NotNull(message = "Address Should not be null")
    private String address;
}
