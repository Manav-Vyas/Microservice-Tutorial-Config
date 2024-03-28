package com.user.service.Services;

import java.util.List;

import com.user.service.Entity.User;

public interface UserService {

	User createUser(User user);
	List<User> getAllUsers();
	User getSingleUser(String userId);
	void deleteSingleUser(String userId);
	User updateSingleUser(String userId);
}
