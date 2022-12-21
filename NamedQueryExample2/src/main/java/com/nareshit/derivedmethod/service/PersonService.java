package com.nareshit.derivedmethod.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nareshit.derivedmethod.dao.BookDao;
import com.nareshit.derivedmethod.dao.PersonDao;
import com.nareshit.derivedmethod.model.Book;
import com.nareshit.derivedmethod.model.Person;

@Service
public class PersonService {

	@Autowired
	private PersonDao personDao;

	@Autowired
	private BookDao bookdao;

	public Iterable<Person> saveAllPersons(Iterable<Person> personsList) {
		return personDao.saveAll(personsList);
	}

	public Iterable<Person> findPersons(Iterable<Integer> personIds){
		return personDao.findAllById(personIds);
	}

	public Iterable<Person> findByLastName(String lastName){
		return personDao.findByLastName(lastName);
	}

	public Person findByLastNameAndFirstName(String lastName,String firstName) {
		return personDao.findByLastNameAndFirstName(lastName, firstName);
	}

	public Iterable<Person> findByLastNameOrFirstName(String lastName,String firstName){
		return personDao.findByLastNameOrFirstName(lastName, firstName);
	}

	public Iterable<Person> findByLastNameOrderByCreatedDateDesc(String lastName){
		return personDao.findByLastNameOrderByCreatedDateDesc(lastName);
	}

	public Iterable<Person> findByAgeLessThanEqual(Integer age){
		return personDao.findByAgeLessThanEqual(age);
	}

	public List<Person> findByFirstNameLike(String firstName){
		return personDao.findByFirstNameLike(firstName);
	}
	public List<Person> findByLastNameAndAgeLessThanEqual(String lastName,int age){
		return personDao.findByLastNameAndAgeLessThanEqual(lastName, age);
	}

	public List<Person> findByCreatedDateBetween(Date startdate,Date endDate){
		return personDao.findByCreatedDateBetween(startdate, endDate);
	}

	public List<Person> fetchDataWithName(String firstName){
		return personDao.fetchDataWithName(firstName);
	}

   public Iterable<Book> saveAllBooks(Iterable<Book> booksList){
	   return bookdao.saveAll(booksList);
   }

   public Iterable<Book> getAllBooks(){
	   return bookdao.findAll();
   }

   public  Book findByBookName(String bookName) {
	   return bookdao.findByBookName(bookName);
   }
}
