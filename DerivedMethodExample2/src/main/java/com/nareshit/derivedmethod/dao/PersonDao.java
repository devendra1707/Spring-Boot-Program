package com.nareshit.derivedmethod.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nareshit.derivedmethod.model.Person;

@Repository
public interface PersonDao extends CrudRepository<Person, Integer>{

	// Derived Method Section
	
	public Iterable<Person> findByLastName(String lastName);
		// Select * from tbl_person where last_name=lasstName;
		
	public Person findByLastNameAndFirstName(String lastName, String firstName);	
	// select * from tbl_person where last_name = lastName and first_name = firstName;

	public Iterable<Person> findByLastNameOrFirstName(String lastName, String firstName);	
	// select * from tbl_person where last_name = lastName or first_name = firstName;

	public Iterable<Person> findByLastNameOrderByCreatedDateDesc(String lastName);	
	// select * from tbl_person where last_name = lastName order by created_date desc;

	public Iterable<Person> findByAgeLessThanEqual(Integer age);
	// Select * from tbl_person where age <= age;
	
	public List<Person> findByFirstNameLike(String firstName);
	// select * from tbl_person where first_name like firstName;
	// But if we want wild card search input string can be in middle or starting position or at ending position
	// we need to manually add % symbol
		// select * from tbl_person where first_name like %firstName% 
	
	public List<Person> findByLastNameAndAgeLessThanEqual(String lastName, int Age);
	// select * from tbl_person where last_name = lastName and age<=lastName
	
	public List<Person> findByCreatedDateBetween(Date startDate, Date endDate); 
	// select * from tbl_person where created_date>=startdate and created_date<=endDate;
	
	
}
