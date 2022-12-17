package com.nareshit.derivedmethod.service;

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

}
