package com.mongodb.restapi.controller;

import com.mongodb.restapi.dto.UserDTO;
import com.mongodb.restapi.model.Post;
import com.mongodb.restapi.model.User;
import com.mongodb.restapi.services.PostService;
import com.mongodb.restapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/posts")
public class PostController {

    @Autowired
    private PostService service;

    @GetMapping(value = "/findById/{id}")
    public ResponseEntity<Post> findById (@PathVariable("id")String id) throws Exception {
        Post post = service.findById(id);
        return ResponseEntity.ok().body(post);
    }

}
