package com.example.demo.service;

import com.example.demo.exception.InternalStandardError;
import com.example.demo.exception.UserServiceException;
import com.example.demo.model.ResponseObject;
import com.example.demo.model.UserDto;
import com.example.demo.repo.UserRepo;
import com.example.demo.repo.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public ResponseObject saveUser(UserDto userDto) {
        log.debug("save user called..");
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        user.setUId(UUID.randomUUID().toString());
        User savedUser = userRepo.save(user);
        log.info("user saved successfully : {}", savedUser.getUId());
        return ResponseObject.builder().status("User Saved with id: " + savedUser.getUId()).build();
    }


    public ResponseObject findUser(String uId) {
        Optional<User> userOpt = userRepo.findById(uId);
        if (!userOpt.isPresent()) {
            log.error("user not found with id {}", uId);
            throw new UserServiceException(InternalStandardError.USER_NOT_FOUND);
        }
        log.info("retrieving user info : {}", uId);
        return ResponseObject.builder().data(userOpt.get()).build();
    }
}
