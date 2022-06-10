package edu.mum.cs544.exception.controller;

import edu.mum.cs544.exception.ApiError;
import edu.mum.cs544.exception.CommentNotFoundException;
import edu.mum.cs544.exception.PostNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class CommentNotFoundExceptionHandler {

    @ExceptionHandler(CommentNotFoundException.class)
    public ResponseEntity<?> commentNotFoundExc(CommentNotFoundException ex) {
         ApiError error = ApiError.builder()
                .description(ex.getMessage())
                .message(ex.getMessage())
                .statusCode(HttpStatus.BAD_REQUEST.toString())
                .build();

        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PostNotFoundException.class)
    public ResponseEntity<?> PostNotFound(PostNotFoundException ex){
        ApiError error = ApiError
                .builder()
                .description(ex.getMessage())
                .message(ex.getMessage())
                .statusCode(HttpStatus.BAD_REQUEST.toString())
                .build();

        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
}
