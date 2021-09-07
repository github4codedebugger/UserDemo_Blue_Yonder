package com.example.demo.exception;

import lombok.Getter;

@Getter
public class UserServiceException extends RuntimeException {

    private InternalStandardError error;

    public UserServiceException(InternalStandardError error) {
        this.error = error;
    }
}
