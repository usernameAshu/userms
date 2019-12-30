package com.edureka.userms.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edureka.userms.model.User;
import com.edureka.userms.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> getAllUsers() {
		LOGGER.info("Getting all the User names from Repository");
		return userRepository.findAll(); 
	}

	@Override
	public Optional<User> getSingleUser(Long id) {
		LOGGER.info("Getting Single User by ID");
		return userRepository.findById(id);
	}

	@Override
	public void createUser(User user) {

	}

	@Override
	public void updateUser(User user) {

	}

	@Override
	public void deleteUser(Long userid) {

	}

	@Override
	public Optional<User> findById(Long id) {
		return null;
	}

	@Override
	public Optional<User> findByName(String userName) {
		return null;
	}

}
