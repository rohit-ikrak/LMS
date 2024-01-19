package com.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserBooksDao;
import com.model.UserBooks;

@Service
public class UserBooksServices {
	
	
	@Autowired
	private UserBooksDao userBooksDao; 
	
	public void addData(UserBooks userBook) {
		List<UserBooks> userBooks = this.userBooksDao.getAllData();
		int count=0;
		for(UserBooks ub: userBooks) {
			if(ub.equals(userBook)) {
				count++;
			}
		}
		if(count==0){
			this.userBooksDao.addData(userBook);
		}
	}
	public void updateData(UserBooks userBooks) {
		this.userBooksDao.updateData(userBooks);
	}
	public void deleteData(Long id) {
		this.userBooksDao.deleteData(id);
	}
	public UserBooks getData(Long id) {
		return this.userBooksDao.getData(id);
	}
	public List<UserBooks> getAllData(){
		return this.userBooksDao.getAllData();
	}
	
	public List<Long> getBooksIdByUserId(Long uid) {
		
		List<UserBooks> userBooks = userBooksDao.getAllData();
		System.out.println("UserBooks values are (ID__BID__UID) : " + userBooks);
		List<Long> booksIds = new ArrayList<>();
		
		for(UserBooks userBook: userBooks) {
			if(userBook.getUserId().equals(uid)) {
				booksIds.add(userBook.getBookId());
			}
		}
		System.out.println("BooksIds for user " + uid +" are : " + booksIds);
		return booksIds;
	}
	
	
	
}
