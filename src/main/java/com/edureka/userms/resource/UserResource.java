package com.edureka.userms.resource;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edureka.userms.model.User;
import com.edureka.userms.service.UserService;

@RestController
@RequestMapping(value = "/userms/api")
@RefreshScope
public class UserResource {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserResource.class);

	@Autowired
	private UserService userService;

	@Value("${my-property}")
	private String myProperty;

	@Value("${your-property}")
	private String yourProperty;

	@GetMapping("/getProperties")
	public List<String> getProperties() {
		return Arrays.asList(myProperty, yourProperty);
	}

	@GetMapping(value = "/allusers")
	public ResponseEntity getAllUsers() {
		LOGGER.info("getting all users from service");
		return ResponseEntity.ok(userService.getAllUsers());
	}

	@GetMapping(value = "/user/{user_id}")
	public ResponseEntity getUserByID(@PathVariable long user_id) {
		LOGGER.info("Getting single user from service");
		Optional<User> singleUser = userService.getSingleUser(user_id);

		if (singleUser.isPresent())
			return ResponseEntity.ok(singleUser);
		else
			return ResponseEntity.notFound().build();
	}

	/*
	 * External API calling using rest template Calling API of Order-MS from API of
	 * USER-MS
	 */
	@GetMapping(value = "/getOrdersFromOrderms")
	public ResponseEntity getOrdersFromOrderms() {
		return ResponseEntity.ok(userService.getAllOrder());
	}

}
