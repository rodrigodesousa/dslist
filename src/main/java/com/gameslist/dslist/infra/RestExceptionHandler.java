package com.gameslist.dslist.infra;

import com.gameslist.dslist.exceptions.GameEsgotadoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(GameEsgotadoException.class)
    private ResponseEntity<RestErrorMessage> gameNotFoundHandler(GameEsgotadoException exception){
        RestErrorMessage messageThreated = new RestErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(messageThreated);
    }

    @ExceptionHandler(Exception.class)
    private ResponseEntity<RestErrorMessage> genericErrorHandler(Exception exception){
        RestErrorMessage messageThreated = new RestErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(messageThreated);
    }
}
