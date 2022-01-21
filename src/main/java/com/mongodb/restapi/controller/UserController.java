package com.mongodb.restapi.controller;

import com.mongodb.restapi.model.User;
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

    @GetMapping(value = "/findall")
    public ResponseEntity<List<User>> findAll (){
        User user1 = new User("1", "Anna May Ferreira Santana","annameyferreira@gmail.com");
        User user2 = new User("2", "Nayron Ferreira","nayronferreira@gmail.com");
        User user3 = new User("3", "Nathália Santana","natsantana@gmail.com");
        List<User>list = new ArrayList<>(Arrays.asList(user1,user2));
        return ResponseEntity.ok().body(list);
    }
}
