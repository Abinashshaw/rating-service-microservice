package com.krsna.HotelService.exceptions;

public class HotelException extends RuntimeException{
    public HotelException(String s) {
        throw new RuntimeException(s);
    }
}
