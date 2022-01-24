package com.mongodb.restapi.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Document (collection = "user")
public class User implements Serializable {

    @Id
    private String id;
    private String name;
    private String email;
    @DBRef (lazy = true)
    private List<Post> posts = new ArrayList<>();

    public User (String id, String name, String email){
        this.id= id;
        this.name=name;
        this.email=email;
    }
}
