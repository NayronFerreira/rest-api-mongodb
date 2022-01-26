package com.mongodb.restapi.controller;

import com.mongodb.restapi.controller.util.URL;
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
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/posts")
public class PostController {

    @Autowired
    private PostService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable("id")String id) throws Exception {
        Post post = service.findById(id);
        return ResponseEntity.ok().body(post);
    }

    @GetMapping (value = "/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam (value = "text", defaultValue = "") String text){
        text = URL.decodeParam(text);
        List<Post>postList = service.findByTitleContaining(text);
        return ResponseEntity.ok().body(postList);
    }

    @GetMapping (value = "/fullsearch")
    public ResponseEntity<List<Post>> fullSearch(@RequestParam (value = "text", defaultValue = "") String text,
                                                 @RequestParam (value = "minDate", defaultValue = "") String minDate,
                                                 @RequestParam (value = "maxDate", defaultValue = "") String maxDate){
        text = URL.decodeParam(text);
        Date min = URL.convertDate(minDate, new Date(0L));
        Date max = URL.convertDate(maxDate, new Date(0L));

        List<Post>postList = service.fullSearch(text, min, max);
        return ResponseEntity.ok().body(postList);
    }

}
