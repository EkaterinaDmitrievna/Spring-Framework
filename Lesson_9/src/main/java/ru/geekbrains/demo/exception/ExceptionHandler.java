package ru.geekbrains.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.geekbrains.demo.dto.ErrorResponse;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler({NoSuchElementException.class})
    public ResponseEntity<ErrorResponse> handleEmptyResponse(Exception ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(ex.getMessage()));

    }
}
