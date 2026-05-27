package com.krsna.RatingService.exceptions;

public class RatinglException extends RuntimeException{
    public RatinglException(String s) {
        throw new RuntimeException(s);
    }
}
