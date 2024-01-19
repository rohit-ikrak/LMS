package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="userbooks")
public class UserBooks {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private Long userId;
	@Column(nullable = false)
	private Long bookId;
	@Override
	public String toString() {
		return "UserBooks [id=" + id + ", userId=" + userId + ", bookId=" + bookId + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getBookId() {
		return bookId;
	}
	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}
	public UserBooks() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserBooks(Long id, Long userId, Long bookId) {
		super();
		this.id = id;
		this.userId = userId;
		this.bookId = bookId;
	}
	
	
}
