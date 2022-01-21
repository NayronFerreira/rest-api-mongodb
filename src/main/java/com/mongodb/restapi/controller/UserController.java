package com.mongodb.restapi.controller;

import com.mongodb.restapi.model.User;
import com.mongodb.restapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping(value = "/findall")
    public ResponseEntity<List<User>> findAll (){
        return ResponseEntity.ok().body(service.findall());
    }
}
