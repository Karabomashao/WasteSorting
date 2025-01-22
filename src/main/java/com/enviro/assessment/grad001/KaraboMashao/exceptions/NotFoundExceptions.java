package com.enviro.assessment.grad001.KaraboMashao.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundExceptions extends ResponseStatusException {
    public  NotFoundExceptions(String message){
        super(HttpStatus.NOT_FOUND, message);
    }
}
