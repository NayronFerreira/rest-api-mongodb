package com.mongodb.restapi.services;

import com.mongodb.restapi.exception.ObjectNotFound;
import com.mongodb.restapi.model.User;
import com.mongodb.restapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findall(){
        return repository.findAll();
    }

    public User findById (String id) throws Exception {
        Optional<User> user = repository.findById(id);
        return user.orElseThrow(()-> new ObjectNotFound("User not found =("));
    }

}
