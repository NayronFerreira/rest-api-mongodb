package com.mongodb.restapi.repository;

import com.mongodb.restapi.model.Post;
import com.mongodb.restapi.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
