package com.krsna.HotelService.exceptions;

import com.krsna.HotelService.payload.ApiRespose;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(HotelException.class)
    public ResponseEntity<ApiRespose> UserExceptionHandler(String message){
        ApiRespose response = ApiRespose.builder().message(message).success(false).status(HttpStatus.BAD_REQUEST).build();
        return ResponseEntity.ok(response);
    }

}
