package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="books")
public class Books {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String bookId;
	@Column(nullable = false)
	private String title;
	@Column(nullable = false)
	private String author;
	@Column(nullable = false)
	private String description;	
	@Column(nullable = false)
	private String genre;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	@Override
	public String toString() {
		return "Books [id=" + id + ", bookId=" + bookId + ", title=" + title + ", author=" + author + ", description="
				+ description + ", genre=" + genre + "]";
	}
	public Books() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Books(Long id, String bookId, String title, String author, String description, String genre) {
		super();
		this.id = id;
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.description = description;
		this.genre = genre;
	}
	
}
