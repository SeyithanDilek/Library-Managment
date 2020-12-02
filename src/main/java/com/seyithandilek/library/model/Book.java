package com.seyithandilek.library.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name="books")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="isbn")
	private String isbn;
	
	@Column(name="serialName")
	private String serialName;
	
	@ManyToOne
	@JoinColumn(name="author_id",nullable = false)
	private Author author;
	
	@ManyToOne
	@JoinColumn(name="publisher_id",nullable = false)
	private Publisher publisher;

	public Book(String title, String isbn, String serialName) {
		this.title = title;
		this.isbn = isbn;
		this.serialName = serialName;
	}

	public Book(String title, String isbn, String serialName, Author author, Publisher publisher) {
		this.title = title;
		this.isbn = isbn;
		this.serialName = serialName;
	}
	

	
}
