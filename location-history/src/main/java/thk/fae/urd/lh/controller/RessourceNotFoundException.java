package thk.fae.urd.lh.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RessourceNotFoundException extends RuntimeException {
    public RessourceNotFoundException(String exception) {
        super(exception);
    }
}
