package com.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.model.UserBooks;

@Repository
public class UserBooksDaoImpl implements UserBooksDao{

	@Autowired
	HibernateTemplate hibernateTemplate;
	
	@Override
	@Transactional
	public void addData(UserBooks userbooks) {
		// TODO Auto-generated method stub
		this.hibernateTemplate.save(userbooks);
		
	}

	@Override
	@Transactional
	public void updateData(UserBooks userbooks) {
		// TODO Auto-generated method stub
		this.hibernateTemplate.update(userbooks);
		
	}

	@Override
	@Transactional
	public void deleteData(Long id) {
		// TODO Auto-generated method stub
		UserBooks userbook = this.hibernateTemplate.load(UserBooks.class, id);
		this.hibernateTemplate.delete(userbook);
		
	}

	@Override
	public List<UserBooks> getAllData() {
		// TODO Auto-generated method stub
		List<UserBooks> userbooks = this.hibernateTemplate.loadAll(UserBooks.class);
		return userbooks;
	}

	@Override
	public UserBooks getData(Long id) {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.get(UserBooks.class, id);
		
	}

}
