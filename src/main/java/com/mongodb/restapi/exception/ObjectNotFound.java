package com.mongodb.restapi.exception;

public class ObjectNotFound extends RuntimeException{
    public ObjectNotFound(String msg){
        super(msg);
    }
}
