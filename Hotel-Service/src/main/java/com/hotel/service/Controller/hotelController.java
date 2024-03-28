package com.hotel.service.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.service.Entity.Hotel;
import com.hotel.service.Service.hotelService;

@RestController
@RequestMapping("/hotels")
public class hotelController {

	@Autowired
	private hotelService hotelService;
	
	@PostMapping
	public ResponseEntity<Hotel> saveHotel(@RequestBody Hotel hotel){
		Hotel hotel1 = hotelService.saveHotel(hotel);
		return ResponseEntity.status(HttpStatus.CREATED).body(hotel1);
	}
	
	@GetMapping
	public ResponseEntity<List<Hotel>> getAllHotels(){
		List<Hotel> hotel = hotelService.getAllHotels();
		return ResponseEntity.ok(hotel);
	}
	
	@GetMapping("/{hotelId}")
	public ResponseEntity<Hotel> getHotelBasedOnId(@PathVariable String hotelId){
		Hotel hotel = hotelService.getHotelBasedOnId(hotelId);
		return ResponseEntity.ok(hotel);
	}
	
	@DeleteMapping("/{delete}/{hotelId}")
	public void deleteHotelBasedOnId(@PathVariable String hotelId) {
		hotelService.deleteHotelBasedOnId(hotelId);
	}
	
	@PutMapping("/{update}/{hotelId}")
	public ResponseEntity<Hotel> updateBasedOnId(@PathVariable String hotelId){
		Hotel hotel = hotelService.updateHotelBasedOnId(hotelId);
		return ResponseEntity.ok(hotel);
	}
}
