package com.mongodb.restapi.services;

import com.mongodb.restapi.model.User;
import com.mongodb.restapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findall(){
        User user1 = new User("1", "Anna May Ferreira Santana","annameyferreira@gmail.com");
        User user2 = new User("2", "Nayron Ferreira","nayronferreira@gmail.com");
        User user3 = new User("3", "Nathália Santana","natsantana@gmail.com");
        List<User>list = new ArrayList<>(Arrays.asList(user1,user2,user3));
        repository.insert(list);
        return repository.findAll();
    }

}
