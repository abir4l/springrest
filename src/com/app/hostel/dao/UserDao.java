package com.app.hostel.dao;

import java.util.List;




import com.app.hostel.entity.User;


public interface UserDao{

	public void createUser(User user);

	public User getUser(Integer id);
	
	public List<User> getUsers();
	
	public void updateUser(User user);
	
	public void deleteUser(Integer id);
	
	
}
