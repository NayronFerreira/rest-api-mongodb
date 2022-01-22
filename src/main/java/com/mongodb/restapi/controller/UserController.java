package com.mongodb.restapi.controller;

import com.mongodb.restapi.dto.UserDTO;
import com.mongodb.restapi.model.User;
import com.mongodb.restapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping(value = "/findall")
    public ResponseEntity<List<UserDTO>> findAll (){
        List<User>list = service.findall();
        List<UserDTO>listDto = list.stream().map(user -> new UserDTO(user)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }
    @GetMapping(value = "/findById/{id}")
    public ResponseEntity<UserDTO> findById (@PathVariable("id")String id) throws Exception {
        UserDTO userDTO = new UserDTO(service.findById(id));
        return ResponseEntity.ok().body(userDTO);
    }
}
