package com.krsna.HotelService.controllers;

import com.krsna.HotelService.entitities.Hotel;
import com.krsna.HotelService.services.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
@RequiredArgsConstructor
public class HotelController {

    private final HotelService hotelService;

    @PostMapping
    public ResponseEntity<Hotel> saveHotel(@RequestBody Hotel hotel) {
        return new ResponseEntity<>(hotelService.createHotel(hotel), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotel() {
        return new ResponseEntity<>(hotelService.getAllHotel(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable String id) {
        return new ResponseEntity<>(hotelService.getHotelById(id), HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Hotel>> getHotelByName(@PathVariable String name) {
        return new ResponseEntity<>(hotelService.getHotelByName(name), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteHotelById(@PathVariable String id) {
        hotelService.deleteHotelById(id);
        return new ResponseEntity<>("Hotel deleted successfully", HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Hotel> updateHotel(@PathVariable String id, @RequestBody Hotel hotel) {
        return new ResponseEntity<>(hotelService.updateHotel(hotel, id), HttpStatus.OK);
    }


}
