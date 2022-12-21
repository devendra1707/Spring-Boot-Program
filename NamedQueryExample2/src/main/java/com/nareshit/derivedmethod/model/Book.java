package com.nareshit.derivedmethod.model;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_book")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "book_name")
	private String bookName;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "book_publisher",
	joinColumns = @JoinColumn(
			name = "book_id", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "publisher_id", referencedColumnName = "id")
	)
	private Set<Publisher> publishers;




	public Book() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Set<Publisher> getPublishers() {
		return publishers;
	}

	public void setPublishers(Set<Publisher> publishers) {
		this.publishers = publishers;
	}

	public Book(String bookName, Set<Publisher> publishers) {
		super();
		this.bookName = bookName;
		this.publishers = publishers;
	}

	@Override
	public String toString() {

		String result = String.format("Book Data  [id=%d,name='%s']%n", id, bookName);
		// Book Data[id=1,name='Book A']

		if (publishers != null)
			for (Publisher publisher : publishers) {

				result += String.format("Publisher [id=%d,name='%s']%n", publisher.getId(),
						publisher.getPublisherName());
			}

		return result;

	}
}
