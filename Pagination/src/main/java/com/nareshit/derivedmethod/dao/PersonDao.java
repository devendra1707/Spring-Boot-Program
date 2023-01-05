package com.nareshit.derivedmethod.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nareshit.derivedmethod.model.CustomType;
import com.nareshit.derivedmethod.model.Person;

@Repository
public interface PersonDao extends JpaRepository<Person, Integer>{

//Derived Methods Section


	public List<Person> findByLastName(String lastName);
	//select * from tbl_person where last_name=lastName


	public Person findByLastNameAndFirstName(String lastName,String firstName);
	//select * from tbl_person where last_name =lastName and first_name=firstName

	public Iterable<Person> findByLastNameOrFirstName(String lastName,String firstName);
	//select * from tbl_person where last_name =lastName or first_name=firstName


	public Iterable<Person> findByLastNameOrderByCreatedDateDesc(String lastName);
	//select * from tbl_person where last_name=lastName order by created_date desc

	public Iterable<Person> findByAgeLessThanEqual(Integer age);
	//select * from tbl_person where age<=age


	public List<Person> findByLastNameAndAgeLessThanEqual(String lastName,int age);
	//select * from tbl_person where last_name=lastName and age<=lastName


	public List<Person> findByFirstNameLike(String firstName);
	//select * from tbl_person where first_name like firstName;
//But if we want wild card search input string can be in middle or starting position or at ending position.
	//we need to manually add % symbol
	//select * from tbl_person where first_name like %firstName%

	public List<Person> findByCreatedDateBetween(Date startdate,Date endDate);
	//select * from tbl_person where created_date>=startdate and created_date<=endDate;


	//Abstract method at Interface and Implementation at POJO Class --> Named Query
	public List<Person> fetchDataWithName(String firstName);
	
	public Iterable<CustomType> fetchFewColumns(String lastName);
	
	// Query -> We are going to write JPQL -> writing Java Classes and Java properties
	@Query(value="SELECT p FROM Person p where p.firstName=?1 OR p.email=?2")
	List<Person> findPersonInfobyFirstNameorEmail(String firstName,String email);
	
	// NativeQuery -> We are going to write SQL -> riting database tables and database Columns
	@Query(value="SELECT * FROM tbl_Person p where p.first_name=?1",nativeQuery = true)
	List<Person> findPersonINfobyFirstname(String firstName);

	//Pagination
	//Pageable ==> Achieved for pagination
	public List<Person> findByLastName(String lastName,Pageable pagination);
} 




