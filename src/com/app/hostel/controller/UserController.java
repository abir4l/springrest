package com.app.hostel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.hostel.entity.User;
import com.app.hostel.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value="/{userId}",method = RequestMethod.GET)
	public ResponseEntity<User> getUser(@PathVariable("userId") Integer id){
		
		
		return new ResponseEntity<>(userService.getUser(id),HttpStatus.OK);
		
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> getAllUsers(){
		return new ResponseEntity<>(userService.getUsers(),HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> createUser(@RequestBody User user){
			
			userService.createUser(user);
			return new ResponseEntity<>(HttpStatus.CREATED);
			

	}
	
	@RequestMapping(method= RequestMethod.PUT)
	public ResponseEntity<User> updateUser(@RequestBody User user){

		userService.updateUser(user);
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
	
	@RequestMapping(value="/{userId}",method= RequestMethod.DELETE)
	public ResponseEntity<String> deleteUser(@PathVariable("userId") Integer id){
		
		userService.deleteUser(id);
		return new ResponseEntity<>("Deleted Successfully",HttpStatus.OK);
	}
	
}
