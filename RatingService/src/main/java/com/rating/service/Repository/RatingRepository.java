package com.rating.service.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rating.service.Entity.Rating;

public interface RatingRepository extends JpaRepository<Rating, String> {

	List<Rating> findByUserId(String userId);
	List<Rating> findByHotelId(String hotelId);
}
