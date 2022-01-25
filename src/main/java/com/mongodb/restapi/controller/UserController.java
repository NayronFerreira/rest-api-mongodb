package com.mongodb.restapi.controller;

import com.mongodb.restapi.dto.UserDTO;
import com.mongodb.restapi.model.Post;
import com.mongodb.restapi.model.User;
import com.mongodb.restapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PostMapping(value = "/insert")
    public ResponseEntity<User> insert (@RequestBody UserDTO userDTO){
        User userInsered = service.fromDTO(userDTO);
        userInsered = service.insert(userInsered);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userInsered.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> deleteById (@PathVariable("id")String id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping (value = "/update/{id}")
    public ResponseEntity<Void> update (@RequestBody UserDTO userDTO, @PathVariable ("id") String id) throws Exception{
        User userUpdate = service.fromDTO(userDTO);
        userUpdate.setId(id);
        userUpdate = service.update(userUpdate);
        return ResponseEntity.noContent().build();
    }

    @GetMapping (value = "/{id}/posts")
    public ResponseEntity<List<Post>>postsList (@PathVariable("id")String id) throws Exception {
        User user = service.findById(id);
        return ResponseEntity.ok().body(user.getPosts());
    }
}
