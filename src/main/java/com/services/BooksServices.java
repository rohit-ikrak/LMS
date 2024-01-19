package com.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.BooksDao;
import com.model.Books;

@Service
public class BooksServices {
	@Autowired
	private BooksDao booksDao;
	@Autowired
	private UserBooksServices userBooksServices;
	
	public void createBook(Books book) {
		this.booksDao.createBook(book);
	}
	public void updateBook(Books book) {
		this.booksDao.updateBook(book);
	}
	public void deleteBook(Long bid) {
		this.booksDao.deleteBook(bid);
	}
	public Books getBook(Long bid) {
		return this.booksDao.getBook(bid);
	}
	public List<Books> getBooks(){
		return this.booksDao.getBooks();
	}
	
	public List<Books> returnBooksOfUser(Long uid){

		System.out.println("userID in BooksServices class was: " + uid);
		
		List<Books> books = this.booksDao.getBooks();
		
		List<Long> bookIds = userBooksServices.getBooksIdByUserId(uid);
		System.out.println( "BookIds for 'uid= " + uid +" ' is " + bookIds);
		
		
		
		List<Books> userBooks = new ArrayList<>();
		
		for(Books book : books) {
			if(bookIds.contains(book.getId())) {
				userBooks.add(book);
			}
		}
		System.out.println(userBooks);
		return userBooks;
	}

}
