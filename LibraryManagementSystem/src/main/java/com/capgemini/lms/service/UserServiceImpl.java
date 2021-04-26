package com.capgemini.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.lms.dao.UsersDao;
import com.capgemini.lms.entities.Users;
import com.capgemini.lms.exception.AddressNotFoundException;
import com.capgemini.lms.exception.UserNotFoundException;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UsersDao userDao;

	@Override
	public Users register(Users user) {
		
			return userDao.save(user);
	}

	@Override
	public List<Users> viewAllUsers() {
		return userDao.findAll();
	}

	@Override
	public Users updateUserDetails(Users user) {
		int userId = user.getUserid();
		if (!userDao.existsById(userId))
			throw new UserNotFoundException();
		else
			return userDao.save(user);
	}

	@Override
	public void deleteUser(int id) {
		if (userDao.existsById(id))
			userDao.deleteById(id);
		else
			throw new UserNotFoundException();
	}

}
