package com.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.model.Books;

@Repository
public class BooksDaoImpl implements BooksDao{
	
	@Autowired
	HibernateTemplate hibernateTemplate;
	
	
	@Override
	@Transactional
	public void createBook(Books book) {
		// TODO Auto-generated method stub
		this.hibernateTemplate.save(book);
	}

	@Override
	@Transactional
	public void updateBook(Books book) {
		// TODO Auto-generated method stub
		this.hibernateTemplate.update(book);
	}

	@Override
	@Transactional
	public void deleteBook(Long bid) {
		// TODO Auto-generated method stub
		Books book = this.hibernateTemplate.load(Books.class, bid);
		this.hibernateTemplate.delete(book);
	}

	@Override
	public List<Books> getBooks() {
		// TODO Auto-generated method stub
		List<Books> books = this.hibernateTemplate.loadAll(Books.class);
		return books;
	}

	@Override
	public Books getBook(Long bid) {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.get(Books.class, bid);
	}
	
}
