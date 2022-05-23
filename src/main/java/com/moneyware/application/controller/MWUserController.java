package com.moneyware.application.controller;


import com.moneyware.application.message.MWResponseMessage;
import com.moneyware.application.model.User;
import com.moneyware.application.service.MWUserStorageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.moneyware.application.util.MWConstants.CREATE_USER_ERROR_MESSAGE;
import static com.moneyware.application.util.MWConstants.CREATE_USER_SUCCESS_MESSAGE;

@RestController
@RequestMapping("/user")
@CrossOrigin()
public class MWUserController {
    @Autowired
    MWUserStorageServiceImpl service;
    @PostMapping("/createUser")
    public ResponseEntity<MWResponseMessage> createUser(@RequestBody User user) {
        String message = "";
        try {
            User createdUser = service.saveUser(user);
            message = CREATE_USER_SUCCESS_MESSAGE + createdUser.getName();
            return ResponseEntity.status(HttpStatus.OK).body(new MWResponseMessage(message));

        } catch (Exception e) {
            message = CREATE_USER_ERROR_MESSAGE + user.getName() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MWResponseMessage(message));
        }
    }
}

