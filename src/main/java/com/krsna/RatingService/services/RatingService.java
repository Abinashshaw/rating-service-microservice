package com.krsna.RatingService.services;

import com.krsna.RatingService.entities.Rating;

import java.util.List;

public interface RatingService {

    List<Rating> getRatings();

    List<Rating> getRatingsByHotelId(String hotelId);

    List<Rating> getRatingsByUserId(String userId);

    Rating createRating(Rating rating);

    void deleteRatingByRatingId(String ratingId);

    Rating updateRating(Rating rating, String ratingId);

    Rating getRatingByRatingId(String ratingId);
}
