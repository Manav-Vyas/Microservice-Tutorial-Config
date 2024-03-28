package com.rating.service.Service;

import java.util.List;

import com.rating.service.Entity.Rating;

public interface RatingService {

	Rating createRatings(Rating rating);
	
	List<Rating> getRatings();
	
	List<Rating> getRatingByUserId(String userId);
	
	List<Rating> getRatingByHotelId(String hotelId);
}
