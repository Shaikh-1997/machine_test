package com.api.machine_test.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFound  extends RuntimeException{
    public ResourceNotFound(String msg){
        super(msg);

    }
}
