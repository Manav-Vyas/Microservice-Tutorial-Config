package com.hotel.service.Service;

import java.util.List;

import com.hotel.service.Entity.Hotel;

public interface hotelService {

	Hotel saveHotel(Hotel hotel);
	List<Hotel> getAllHotels();
	Hotel getHotelBasedOnId(String hotelId);
	void deleteHotelBasedOnId(String hotelId);
	Hotel updateHotelBasedOnId(String hotelId);
}
