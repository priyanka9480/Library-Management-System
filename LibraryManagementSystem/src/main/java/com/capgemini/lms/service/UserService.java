package com.capgemini.lms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.lms.entities.Users;

@Service
public interface UserService {
	public Users register(Users user);
//	public Users loginValidate(String username,String password);
//	public void cancelSubscription(int userid);
//	public int payThePenalty(int userid, double amount);
	public List<Users> viewAllUsers();
	public Users updateUserDetails(Users user);
	public void deleteUser(int id);
}
