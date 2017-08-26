package com.app.hostel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.app.hostel.dao.UserDao;
import com.app.hostel.dao.UserDaoImpl;
import com.app.hostel.entity.User;



@Service("userService")
public class UserService {
	
	@Autowired
	private UserDao userDaoImpl;

	 
	public void createUser(User user) {
		 
		userDaoImpl.createUser(user);
		
	}

	 
	public User getUser(Integer id) {
		 
		return userDaoImpl.getUser(id);
	}

	 
	public List<User> getUsers() {
		 
		return userDaoImpl.getUsers();
	}

	 
	public void updateUser(User user) {
		 
		 userDaoImpl.updateUser(user);
	}

	 
	public void deleteUser(Integer id) {
		 
		 userDaoImpl.deleteUser(id);
	}
	
	
	
	
	

}
