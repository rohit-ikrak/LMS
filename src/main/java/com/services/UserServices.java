package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserDao;
import com.model.User;

@Service
public class UserServices {

	@Autowired
	private UserDao userDao;

	public void createUser(User user) {
		userDao.createUser(user);
	}
	public void updateUser(User user) {
		userDao.updateUser(user);
	}
	public void deleteUser(Long uid) {
		userDao.deleteUser(uid);
	}
	public List<User> getUsers(){
		return userDao.getUsers();
	}
	public User getUser(Long uid) {
		return userDao.getUser(uid);
	}	
	public User getUserByEmail(String email) {
		List<User> users = this.userDao.getUsers();
		User existingUser = new User(); 
		for(User user: users) {
			if(user.getEmail().equals(email)) {
				existingUser = user;
				break;
			}
		}
		return existingUser;
	}
	
}
