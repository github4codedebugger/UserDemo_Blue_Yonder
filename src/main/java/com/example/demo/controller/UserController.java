package com.example.demo.controller;

import com.example.demo.model.ResponseObject;
import com.example.demo.model.UserDto;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseObject addUser(@RequestBody @Valid UserDto user) {
        return userService.saveUser(user);
    }


    @GetMapping("/{uId}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_USER')")
    public ResponseObject getUser(@PathVariable String uId) {
        return userService.findUser(uId);
    }
}
