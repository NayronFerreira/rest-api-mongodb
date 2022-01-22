package com.mongodb.restapi.controller.exception;

import com.mongodb.restapi.exception.ObjectNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ObjectNotFound.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFound oe, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError error = new StandardError(System.currentTimeMillis(), status.value(),"Não econtrado" ,oe.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(error);
    }
}
