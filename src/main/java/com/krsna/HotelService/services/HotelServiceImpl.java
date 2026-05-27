package com.krsna.HotelService.services;

import com.krsna.HotelService.entitities.Hotel;
import com.krsna.HotelService.exceptions.HotelException;
import com.krsna.HotelService.repositories.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {
    private HotelRepository hotelRepository;

    public HotelServiceImpl(HotelRepository hotelRepository){
        this.hotelRepository = hotelRepository;
    }

    @Override
    public Hotel createHotel(Hotel hotel) {
        hotel.setHotelId(UUID.randomUUID().toString());
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel getHotelById(String id) {
        return hotelRepository.findById(id).
                orElseThrow(() -> new HotelException("Hotel does not exist with Id "+id));
    }

    @Override
    public List<Hotel> getAllHotel() {
        return hotelRepository.findAll();
    }

    @Override
    public List<Hotel> getHotelByName(String name) {
        return hotelRepository.findByNameContaining(name)
                .orElseThrow(() -> new HotelException("Hotel not found by given name "+name));
    }

    @Override
    public void deleteHotelById(String id){
        Hotel hotel = getHotelById(id);
        hotelRepository.deleteById(id);
    }

    @Override
    public Hotel updateHotel(Hotel hotel, String id) {
        Hotel savedHotel = getHotelById(id);
        if(hotel.getAbout() != null) savedHotel.setAbout(hotel.getAbout());
        if(hotel.getName() != null) savedHotel.setName(hotel.getName());
        if(hotel.getLocation() != null) savedHotel.setLocation(hotel.getLocation());
        return hotelRepository.save(savedHotel);
    }
}
