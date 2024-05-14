package com.github.joanacoll.apibooks.exception;

import com.github.joanacoll.apibooks.dto.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionConfig {
    @ExceptionHandler(EntityAlreadyExistException.class)
    public ResponseEntity<?> entityAlreadyExistException(EntityAlreadyExistException e) {
        ErrorResponse errorResponse = new ErrorResponse(409, e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> entityNotFoundException(EntityNotFoundException e){
        ErrorResponse errorResponse = new ErrorResponse(404, e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}