package com.nareshit.derivedmethod.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nareshit.derivedmethod.dao.PersonDao;
import com.nareshit.derivedmethod.model.Person;

@Service
public class PersonService {

	@Autowired
	private PersonDao personDao;

	public Iterable<Person> saveAllPersons(Iterable<Person> personsList) {
		return personDao.saveAll(personsList);
	}

	public Iterable<Person> findPersons(Iterable<Integer> personIds){
		return personDao.findAllById(personIds);
	}
	
	public Iterable<Person> findByLastName(String lastName){
		return personDao.findByLastName(lastName);
	}
	
	public Person findByLastNameAndFirstName(String lastName, String firstName) {
		return personDao.findByLastNameAndFirstName(lastName, firstName);
	}
	
	public Iterable<Person> findByLastNameOrFirstName(String lastName, String firstName){
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
	
	public List<Person> findByLastNameAndAgeLessThanEqual(String lastName, int Age){
		return personDao.findByLastNameAndAgeLessThanEqual(lastName, Age);
	}
	
	public List<Person> findByCreatedDateBetween(Date startDate, Date endDate){
		return personDao.findByCreatedDateBetween(startDate, endDate);
	}
	
	public List<Person> fetchDataWithName(String firstName){
		return personDao.fetchDataWithName(firstName);
	}
}
