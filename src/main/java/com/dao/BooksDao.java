package com.dao;

import java.util.List;

import com.model.Books;

public interface BooksDao {
	void createBook(Books book );
	void updateBook(Books book);
	void deleteBook(Long bid);
	List<Books> getBooks();
	Books getBook(Long bid);
}
