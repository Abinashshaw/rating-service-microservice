package com.krsna.HotelService.repositories;

import com.krsna.HotelService.entitities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HotelRepository extends JpaRepository<Hotel, String> {
    public Optional<List<Hotel>> findByNameContaining(String name);
}
