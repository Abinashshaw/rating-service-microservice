package com.krsna.RatingService.repositories;

import com.krsna.RatingService.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, String> {

    List<Rating> findRatingByUserId(String userId);

    List<Rating> findRatingByHotelId(String hotelId);
}
