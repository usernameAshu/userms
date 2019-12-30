package com.edureka.userms.service;

import java.util.List;
import java.util.Optional;

import com.edureka.userms.model.User;

public interface UserService {

	List<User> getAllUsers();
	Optional<User> getSingleUser(Long id);
	
	void createUser(User user);
	void updateUser(User user);
	void deleteUser(Long userid);
	
	Optional<User> findById(Long id);
	Optional<User> findByName(String userName);

}
