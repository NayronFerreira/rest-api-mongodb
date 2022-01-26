package com.mongodb.restapi.services;

import com.mongodb.restapi.exception.ObjectNotFound;
import com.mongodb.restapi.model.Post;
import com.mongodb.restapi.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById (String id) throws Exception {
        Optional<Post> post = repository.findById(id);
        return post.orElseThrow(()-> new ObjectNotFound("User not found =("));
    }

    public List<Post> findByTitleContaining (String text){
        return repository.findByTitleExampletwo(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate){
        maxDate = new Date(maxDate.getTime()+24*60*60*1000);
        return repository.fullSearch(text, minDate, maxDate);
    }
}
