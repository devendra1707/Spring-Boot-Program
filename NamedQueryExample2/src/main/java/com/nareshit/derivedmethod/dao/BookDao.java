package com.nareshit.derivedmethod.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nareshit.derivedmethod.model.Book;

@Repository
public interface BookDao extends CrudRepository<Book, Integer>{

	public Book findByBookName(String bookName);

}
