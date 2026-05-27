package com.krsna.HotelService.services;

import com.krsna.HotelService.entitities.Hotel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HotelService {

    public Hotel createHotel(Hotel user);

    public Hotel getHotelById(String id);

    public List<Hotel> getAllHotel();

    public List<Hotel> getHotelByName(String name);

    public void deleteHotelById(String id);

    public Hotel updateHotel(Hotel hotel, String id);

}
