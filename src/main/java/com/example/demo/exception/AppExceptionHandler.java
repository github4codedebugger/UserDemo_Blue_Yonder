package com.example.demo.exception;

import com.example.demo.model.ResponseObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;

@RestControllerAdvice
@Slf4j
public class AppExceptionHandler {


    @ExceptionHandler(UserServiceException.class)
    public ResponseEntity<ResponseObject> handleUserServiceException(UserServiceException exception) {
        log.error("Error Occurred {}", exception.getMessage());
        return ResponseEntity.status(exception.getError().getStatus())
                .body(ResponseObject.builder()
                        .status(exception.getError().getStatus().toString())
                        .data("Error occurred..")
                        .build());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseObject handleException(Exception exception) {
        log.error("Error Occurred {}", exception.getMessage());
        log.error("Error StackTrace {}", Arrays.toString(exception.getStackTrace()));
        return ResponseObject.builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR.toString())
                .data("Error occurred..")
                .build();
    }
}
