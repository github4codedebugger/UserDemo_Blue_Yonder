package com.example.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum InternalStandardError {

    USER_NOT_FOUND("User Not exist", HttpStatus.NOT_FOUND, "4001");

    private String errorMessage;
    private HttpStatus status;
    private String errorCode;
}
