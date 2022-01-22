package com.mongodb.restapi.dto;
import com.mongodb.restapi.model.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class UserDTO implements Serializable {

    private String id;
    private String name;
    private String email;

    public UserDTO (User obj){
        this.id=obj.getId();
        this.name=obj.getName();
        this.email=obj.getEmail();
    }
}
