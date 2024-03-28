package com.user.service.ServiceImpl;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.user.service.Entity.Hotel;
import com.user.service.Entity.Rating;
import com.user.service.Entity.User;
import com.user.service.Exception.ResourceNotFoundException;
import com.user.service.Repository.UserRepository;
import com.user.service.Services.UserService;
import com.user.service.external.Service.RatingService;
import com.user.service.external.Service.HotelService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private HotelService hotelService;
	
	@Autowired
	private RatingService ratingService;
	
	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	
	@Override
	public User createUser(User user) {
		String uuid = UUID.randomUUID().toString();
		user.setUserId(uuid);
		return userRepo.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public User getSingleUser(String userId) {
		User user =userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("user id not found on server: "+userId));
		Rating[] ratingOfHotels = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+user.getUserId(), Rating[].class);
		logger.info("{} " , ratingOfHotels);
		
		List<Rating> ratings = Arrays.stream(ratingOfHotels).collect(Collectors.toList());
		//System.out.println(ratings);
		List<Rating> ratingList = ratings.stream().map(rating->{
			//System.out.println(rating.getHotel());
		//	ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
		//	Hotel hotel = forEntity.getBody();
			Hotel hotel = hotelService.getHotel(rating.getHotelId());
		//	logger.info("response status code: {}", forEntity.getStatusCode());
			rating.setHotel(hotel);
			return rating;
		}).collect(Collectors.toList());
		
		user.setRating(ratingList);
		return user;
	}

	@Override
	public void deleteSingleUser(String userId) {
		userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("user deleted successfully."));
	}

	@Override
	public User updateSingleUser(String userId) {
		return userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("user updated successfully."+userId));
	}

}
