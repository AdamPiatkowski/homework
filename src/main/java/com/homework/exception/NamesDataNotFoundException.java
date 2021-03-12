package com.homework.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NamesDataNotFoundException extends RuntimeException {

    @Override
    public String getMessage() {
        return "Names data not available";
    }

}
