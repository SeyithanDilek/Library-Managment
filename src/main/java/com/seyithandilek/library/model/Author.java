package com.seyithandilek.library.model;


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name="authors")
public class Author {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="names")
	private String name;
	
	@Column(name="descriptions")
	private String description;
	
	@OneToMany(mappedBy = "author")
	private Set<Book> book=new HashSet<>();
	
	public Author(String name,String description) {
		this.name=name;
		this.description=description;
	}
	
	

}
