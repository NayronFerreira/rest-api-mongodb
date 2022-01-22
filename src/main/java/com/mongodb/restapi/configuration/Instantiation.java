package com.mongodb.restapi.configuration;

import com.mongodb.restapi.model.User;
import com.mongodb.restapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private UserRepository repository;
    @Override
    public void run(String... args) throws Exception {

        repository.deleteAll();
        User user1 = new User(null,"Anna May Ferreira Santana", "annamay@gmail.com");
        User user2 = new User(null,"Nayron Ferreira", "nayrondev@gmail.com");
        User user3 = new User(null,"Nathalia Ingrid Santana", "natcabecinha@gmail.com");
        repository.saveAll(Arrays.asList(user1,user2,user3));
    }
}
