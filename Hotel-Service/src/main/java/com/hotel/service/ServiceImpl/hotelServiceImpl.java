package com.hotel.service.ServiceImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.service.Entity.Hotel;
import com.hotel.service.Exception.ResourceNotFoundException;
import com.hotel.service.Repository.hotlRepository;
import com.hotel.service.Service.hotelService;

@Service
public class hotelServiceImpl implements hotelService{

	@Autowired
	private hotlRepository hotelRepo;
	
	@Override
		public Hotel saveHotel(Hotel hotel) {
		String uuid = UUID.randomUUID().toString();
		hotel.setHotelId(uuid);
		return hotelRepo.save(hotel);
}
	
	@Override
	public List<Hotel> getAllHotels() {
		return hotelRepo.findAll();
}
	
	@Override
	public Hotel getHotelBasedOnId(String hotelId) {
		return hotelRepo.findById(hotelId).orElseThrow(()->new ResourceNotFoundException("hotels not found get on id"+ hotelId));
}
	
	@Override
	public void deleteHotelBasedOnId(String hotelId) {
		hotelRepo.findById(hotelId).orElseThrow(()-> new ResourceNotFoundException("hotels deleted successfully."+ hotelId));
		
}
	
	@Override
	public Hotel updateHotelBasedOnId(String hotelId) {
 		return hotelRepo.findById(hotelId).orElseThrow(()-> new ResourceNotFoundException("hotels updated successfully."+hotelId));
	}
}
