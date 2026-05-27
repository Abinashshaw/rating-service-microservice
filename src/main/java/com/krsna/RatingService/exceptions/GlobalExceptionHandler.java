package com.krsna.RatingService.exceptions;

import com.krsna.RatingService.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RatinglException.class)
    public ResponseEntity<ApiResponse> UserExceptionHandler(String message){
        ApiResponse response = ApiResponse.builder().message(message).success(false).status(HttpStatus.BAD_REQUEST).build();
        return ResponseEntity.ok(response);
    }

}
