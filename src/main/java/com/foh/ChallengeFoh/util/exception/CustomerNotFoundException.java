package com.foh.ChallengeFoh.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CustomerNotFoundException extends RuntimeException {

    static final long serialVersionUID = -1;

    public CustomerNotFoundException(String message) {
        super(message);
    }
}
