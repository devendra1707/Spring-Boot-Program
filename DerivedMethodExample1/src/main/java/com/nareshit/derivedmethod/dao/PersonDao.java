package com.nareshit.derivedmethod.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nareshit.derivedmethod.model.Person;

@Repository
public interface PersonDao extends CrudRepository<Person, Integer>{

}
