package com.dao;

import java.util.List;

import com.model.User;

public interface UserDao {
	
	void createUser(User user);

    void updateUser(User user);

    List<User> getUsers();

    void deleteUser(Long uid);

    User getUser(Long uid);
}
