package com.krsna.RatingService.controllers;

import com.krsna.RatingService.entities.Rating;
import com.krsna.RatingService.services.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
@RequiredArgsConstructor
public class RatingController {
    private final RatingService ratingService;

    @PostMapping
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating) {
        return new ResponseEntity<>(ratingService.createRating(rating), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Rating>> getRatings() {
        return new ResponseEntity<>(ratingService.getRatings(), HttpStatus.OK);
    }

    @GetMapping("/{ratingId}")
    public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable String userId){
        return new ResponseEntity<>(ratingService.getRatingsByUserId(userId), HttpStatus.OK);
    }

    @GetMapping("{hotelId}")
    public ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable String hotelId){
        return new ResponseEntity<>(ratingService.getRatingsByHotelId(hotelId), HttpStatus.OK);
    }

    //   updateRating
    @PutMapping("/{ratingId}")
    public ResponseEntity<Rating> updateRating(@PathVariable String ratingId, @RequestBody Rating rating) {
        return new ResponseEntity<>(ratingService.updateRating(rating, ratingId), HttpStatus.OK);
    }

    @DeleteMapping("/{ratingId}")
    public ResponseEntity<String> deleteRatingByRatingId(@PathVariable String ratingId) {
        ratingService.deleteRatingByRatingId(ratingId);
        return new ResponseEntity<>("Rating deleted successfully", HttpStatus.OK);
    }
}
