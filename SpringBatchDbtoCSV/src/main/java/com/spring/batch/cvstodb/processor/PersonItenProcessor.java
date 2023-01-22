package com.spring.batch.cvstodb.processor;

import org.springframework.batch.item.ItemProcessor;

import com.spring.batch.cvstodb.model.Person;

public class PersonItenProcessor implements ItemProcessor<Person, Person>{

	@Override
	public Person process(Person person) throws Exception {
		return person;
	}
}
