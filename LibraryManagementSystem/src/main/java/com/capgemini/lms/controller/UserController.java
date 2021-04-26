package com.capgemini.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.lms.dao.UsersDao;
import com.capgemini.lms.entities.Users;
import com.capgemini.lms.exception.BookNotFoundException;
import com.capgemini.lms.exception.UserNotFoundException;
import com.capgemini.lms.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("User Controller")
@RestController
@RequestMapping(value="/User")
public class UserController {
	@Autowired
	UserService userService;
	@Autowired
	UsersDao usersDao;
	
	@ApiOperation(value="Register user")
	@PostMapping(value="/insertUser")
	public ResponseEntity<String> RegisterUser(@RequestBody Users user) 
	{
		
		userService.register(user);
		return new ResponseEntity<>("Inserted user successfully" ,HttpStatus.OK);
		
	}
	
	@PutMapping(value="/updateUser")
	public ResponseEntity<String> updateuser(@RequestBody Users user)
	{
		try {
		userService.updateUserDetails(user);
		return new ResponseEntity<>("Updated user successfully" ,HttpStatus.OK);
		}
		catch(UserNotFoundException  e) {
			throw new BookNotFoundException("Enter Valid User ID");
		}
		
	}
	
	@GetMapping(value="/ViewUsers")
	public List<Users> getAlluser(){
		return userService.viewAllUsers();
	}
	
	
	@DeleteMapping(value="/deleteById/{userId}")
	public ResponseEntity<String> deleteIssuedBook(@PathVariable int userId) {
		try {
			userService.deleteUser(userId);
		return new ResponseEntity<String>("Deleted",HttpStatus.OK);}
		catch(UserNotFoundException  e) {
			throw new BookNotFoundException("Enter Valid User ID");
		}
	}
	
}
