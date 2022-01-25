package com.mongodb.restapi.services;

import com.mongodb.restapi.exception.ObjectNotFound;
import com.mongodb.restapi.model.Post;
import com.mongodb.restapi.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById (String id) throws Exception {
        Optional<Post> post = repository.findById(id);
        return post.orElseThrow(()-> new ObjectNotFound("User not found =("));
    }
}
