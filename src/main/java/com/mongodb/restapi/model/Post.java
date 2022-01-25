package com.mongodb.restapi.model;

import com.mongodb.restapi.dto.AuthorDTO;
import com.mongodb.restapi.dto.CommentedDTO;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Document
public class Post implements Serializable {

    @Id
    private String id;
    private Date date;
    private String title;
    private String body;
    private AuthorDTO author;
    private List<CommentedDTO> comments = new ArrayList<>();

    public Post (String id,Date date, String title, String body, AuthorDTO authorDTO){
        this.id = id;
        this.date = date;
        this.title = title;
        this.body = body;
        this.author = authorDTO;
    }
}
