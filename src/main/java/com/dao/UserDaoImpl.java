package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public void createUser(User user) {
		// Creates a user
		this.hibernateTemplate.save(user);
		
	}

	@Override
	@Transactional
	public void updateUser(User user) {
		// Updates user details
		this.hibernateTemplate.update(user);
		
	}

	@Override
	public List<User> getUsers() {
		// Gets all the User objects with data in a list
		List<User> users = this.hibernateTemplate.loadAll(User.class);
		return users;
	}

	@Override
	public void deleteUser(Long uid) {
		// Deletes a particular user based on the id provided
		User u = this.hibernateTemplate.load(User.class, uid);
		this.hibernateTemplate.delete(u);
	}

	@Override
	public User getUser(Long uid) {
		// Gets a User object with the data of a particular user .
		return this.hibernateTemplate.get(User.class, uid);
	}
	
}
