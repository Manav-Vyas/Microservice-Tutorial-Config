package com.rating.service.ServiceImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rating.service.Entity.Rating;
import com.rating.service.Repository.RatingRepository;
import com.rating.service.Service.RatingService;

@Service
public class RatingServiceImpl implements RatingService {

	@Autowired
	private RatingRepository ratingRepo;
	
	@Override
	public Rating createRatings(Rating rating) {
		String uuid = UUID.randomUUID().toString();
		rating.setRatingId(uuid);
		return ratingRepo.save(rating);
	}

	@Override
	public List<Rating> getRatings() {
		return ratingRepo.findAll();
	}

	@Override
	public List<Rating> getRatingByUserId(String userId) {
		return ratingRepo.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotelId) {
		return ratingRepo.findByHotelId(hotelId);
	}

}
