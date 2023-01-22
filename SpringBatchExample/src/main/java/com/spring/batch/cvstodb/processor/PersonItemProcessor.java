package com.spring.batch.cvstodb.processor;

import org.springframework.batch.item.ItemProcessor;

import com.spring.batch.cvstodb.model.Person;

public class PersonItemProcessor implements ItemProcessor<Person, Person> {

	@Override
	public Person process(final Person person) throws Exception {

		final String firstName = person.getFirstName().toUpperCase();
		final String lastName = person.getLastName().toUpperCase();
		final Person transformedPerson = new Person(firstName, lastName, person.getEmail(),
				person.getAge());
		return transformedPerson;

	}

}
