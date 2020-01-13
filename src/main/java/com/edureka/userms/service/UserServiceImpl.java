package com.edureka.userms.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.edureka.userms.model.User;
import com.edureka.userms.repository.UserRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class UserServiceImpl implements UserService {

	private static final String HTTP_ORDER_MS_ORDERS = "http://order-ms/orders";

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserRepository userRepository;

	private RestTemplate restTemplate;

	public UserServiceImpl(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

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
		/**
		 * to be implemented
		 */
	}

	@Override
	public void updateUser(User user) {
		/**
		 * to be implemented
		 */
	}

	@Override
	public void deleteUser(Long userid) {
		/**
		 * to be implemented
		 */
	}

	@Override
	public Optional<User> findById(Long id) {
		return null;
	}

	@Override
	public Optional<User> findByName(String userName) {
		return null;
	}

	@Override
	@HystrixCommand(fallbackMethod = "getResponseFromFallback")
	public Object getAllOrder() {
		return restTemplate.getForObject(HTTP_ORDER_MS_ORDERS, Object.class);
	}
	
	private Object getResponseFromFallback() {
		User user1 = new User();
		user1.setId(99);
		user1.setName("Fallback User");
		
		User user2 = new User();
		user2.setId(100);
		user2.setName("Perform Necessary actions for Circuit breaker");
		return Arrays.asList(user1,user2);
	}

}
