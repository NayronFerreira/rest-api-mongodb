package com.mongodb.restapi.model;

import lombok.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class User implements Serializable {

    private String id;
    private String name;
    private String email;
}
