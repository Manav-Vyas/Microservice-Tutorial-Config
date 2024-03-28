package com.user.service.external.Service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.user.service.Entity.Rating;

@Service
@FeignClient(name ="RATING-SERVICE")
public interface RatingService {

	@PostMapping("/ratings")
	Rating createRating();
	
	@PutMapping("/ratings/{ratingId}")
	Rating updateRating(@PathVariable("ratingId") String ratingId, Rating rating);
	
	@DeleteMapping("/ratings/{ratingId}")
	void deleteRating(@PathVariable("ratingId") String ratingId);
}
