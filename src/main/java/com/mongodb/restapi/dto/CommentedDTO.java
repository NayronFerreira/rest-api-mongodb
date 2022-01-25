package com.mongodb.restapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CommentedDTO implements Serializable {

    private String text;
    private Date date;
    private AuthorDTO authorDTO;
}
