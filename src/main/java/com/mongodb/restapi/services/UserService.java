package com.mongodb.restapi.services;

import com.mongodb.restapi.dto.UserDTO;
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

    public User insert (User obj){
        return repository.insert(obj);
    }

    public void deleteById (String id){
        repository.deleteById(id);
    }

    public User update (User user) throws Exception {
        User updateUser = findById(user.getId());
        updateData(updateUser,user);
        return repository.save(updateUser);
    }

    public void updateData (User userUpdate, User user){
        userUpdate.setName(user.getName());
        userUpdate.setEmail(user.getEmail());
    }

    public User fromDTO (UserDTO objDTO){
        return new User(objDTO.getId(),objDTO.getName(),objDTO.getEmail());
    }

}
