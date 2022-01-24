package com.mongodb.restapi.configuration;

import com.mongodb.restapi.dto.AuthorDTO;
import com.mongodb.restapi.model.Post;
import com.mongodb.restapi.model.User;
import com.mongodb.restapi.repository.PostRepository;
import com.mongodb.restapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Date;

@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private UserRepository repository;
    @Autowired
    private PostRepository repositoryPost;
    @Override
    public void run(String... args) throws Exception {

        repository.deleteAll();
        repositoryPost.deleteAll();

        User may = new User(null,"Anna May Ferreira Santana", "annamay@gmail.com");
        User nayron = new User(null,"Nayron Ferreira", "nayrondev@gmail.com");
        User user3 = new User(null,"Nathalia Ingrid Santana", "natcabecinha@gmail.com");

        repository.saveAll(Arrays.asList(may,nayron,user3));

        Post post1 = new Post(null, new Date(),"Partiu DEV",
                "Após 2 anos e 6 meses de estudos por conta própria, agora sou DEV, agora que venham grandes desafio e grandes conquitas",new AuthorDTO(nayron));
        Post post2 = new Post(null, new Date(),"Partiu mamar","Eu amo meus pais",new AuthorDTO(may));

        repositoryPost.saveAll(Arrays.asList(post1,post2));

    }
}
