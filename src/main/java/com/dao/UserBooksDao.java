package com.dao;

import java.util.List;

import com.model.UserBooks;

public interface UserBooksDao {
	
	void addData(UserBooks books);
	
	void updateData(UserBooks books);
	
	void deleteData(Long id);
	
	List<UserBooks> getAllData();
	
	UserBooks getData(Long id); 

}
