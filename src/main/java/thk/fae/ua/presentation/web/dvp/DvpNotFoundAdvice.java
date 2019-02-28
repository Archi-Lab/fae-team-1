package thk.fae.ua.presentation.web.dvp;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class DvpNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(DvpNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String dvpNotFoundHandler(DvpNotFoundException ex) {
        return ex.getMessage();
    }

}
