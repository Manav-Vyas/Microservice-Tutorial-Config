package com.user.service.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.service.Entity.User;
import com.user.service.ServiceImpl.UserServiceImpl;
import com.user.service.Services.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userSer;
	
	private Logger logger = LoggerFactory.getLogger(UserController.class);

	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user){
		User user1 = userSer.createUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
	}
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> user = userSer.getAllUsers();
		return ResponseEntity.ok(user);
	}
	
	int retryCount = 1;
	@GetMapping("/{userId}")
	//@Retry(name = "ratingHotelService", fallbackMethod = "ratingHotelFallBackMethod")
	//@CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallBackMethod")
	@RateLimiter(name = "userRatingLimiter", fallbackMethod = "ratingHotelFallBackMethod")
	public ResponseEntity<User> getSingleUser(@PathVariable String userId){
		logger.info("Get Single User Handler: UserController");
		logger.info("Retry Count: {}"+ retryCount);
		retryCount++;
		User user = userSer.getSingleUser(userId);
		return ResponseEntity.ok(user);
	}
	
	//koi service down ho jai gi tab ye method run hogi
	public ResponseEntity<User> ratingHotelFallBackMethod(String userId, Exception ex){
		//logger.info("Fallback is excuted because service is down: ", ex.getMessage());
		User user = User.builder()
						.email("abc@gmail.com")
						.name("abc")
						.about("This user dummy because some server is down")
						.userId("12345")
						.build();
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{userId}")
	public void deleteSingleUser(@PathVariable String userId) {
		userSer.deleteSingleUser(userId);
	}
	
	@PutMapping("/update/{userId}")
	public ResponseEntity<User> updateSingleUser(@PathVariable String userId){
		User user = userSer.updateSingleUser(userId);
		return ResponseEntity.ok(user);
	}
}
