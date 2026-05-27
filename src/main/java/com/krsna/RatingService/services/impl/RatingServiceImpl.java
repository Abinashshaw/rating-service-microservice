package com.krsna.RatingService.services.impl;

import com.krsna.RatingService.entities.Rating;
import com.krsna.RatingService.exceptions.RatinglException;
import com.krsna.RatingService.repositories.RatingRepository;
import com.krsna.RatingService.services.RatingService;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RatingServiceImpl implements RatingService {

    private final RatingRepository ratingRepository;

    @Override
    public List<Rating> getRatings() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> getRatingsByHotelId(String hotelId) {
        return ratingRepository.findRatingByHotelId(hotelId);
    }

    @Override
    public List<Rating> getRatingsByUserId(String userId) {
        return ratingRepository.findRatingByUserId(userId);
    }

    @Override
    public Rating createRating(Rating rating) {
        rating.setRatingId(UUID.randomUUID().toString());
        return ratingRepository.save(rating);
    }

    @Override
    public void deleteRatingByRatingId(String ratingId) {
        getRatingByRatingId(ratingId);
        ratingRepository.deleteById(ratingId);
    }

    @Override
    public Rating updateRating(Rating rating, String ratingId) {
        Rating savedRating = getRatingByRatingId(ratingId);
        if(rating.getRating() != null) savedRating.setRating(rating.getRating());
        if(rating.getFeedback() != null) savedRating.setFeedback(rating.getFeedback());
        if(rating.getUserId() != null) savedRating.setUserId(rating.getUserId());
        if(rating.getHotelId() != null) savedRating.setHotelId(rating.getHotelId());
        return null;
    }

    @Override
    public Rating getRatingByRatingId(String ratingId) {
        return ratingRepository.findById(ratingId)
                .orElseThrow(() -> new RatinglException("Rating not found with id " + ratingId));
    }
}
