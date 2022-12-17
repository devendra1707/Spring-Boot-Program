package com.nareshit.derivedmethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nareshit.derivedmethod.model.Person;
import com.nareshit.derivedmethod.service.PersonService;

@SpringBootApplication
public class DeriedMethodExampleApplication implements CommandLineRunner {


	@Autowired
	private PersonService personService;

	public static void main(String[] args) {
		SpringApplication.run(DeriedMethodExampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		createPersons();
		getPersons();
	}

	private void createPersons() {

		/*
		 * List<Person> personList=new ArrayList<Person>();
		 *
		 * personList.add(new Person("Kiran", "kumar", "kiran@gmail.com", 20));
		 *
		 * personList.add(new Person("Kiran", "kumar", "kiran@gmail.com", 20));
		 *
		 * personList.add(new Person("Kiran", "kumar", "kiran@gmail.com", 20));
		 * personList.add(new Person("Kiran", "kumar", "kiran@gmail.com", 20));
		 * personList.add(new Person("Kiran", "kumar", "kiran@gmail.com", 20));
		 * personList.add(new Person("Kiran", "kumar", "kiran@gmail.com", 20));
		 * personList.add(new Person("Kiran", "kumar", "kiran@gmail.com", 20));
		 * personList.add(new Person("Kiran", "kumar", "kiran@gmail.com", 20));
		 *
		 * personService.saveAllpersons(personList);
		 */

		List<Person> personList = Arrays.asList(
				new Person("Kiran", "kumar", "kiran@gmail.com", 20),
				new Person("Ram", "kumar", "ram@gmail.com", 22),
				new Person("RamKiran", "LaxmiKiran", "laxmi@gmail.com", 30),
				new Person("Lakshamn", "Seth", "seth@gmail.com", 50),
				new Person("Sita", "Kumar", "lakshman@gmail.com", 50),
				new Person("Ganesh", "Kumar", "ganesh@gmail.com", 50),
				new Person("KiranKiran", "kumar", "kiran2@gmail.com", 20),
				new Person("RamRam", "kumar", "ram2@gmail.com", 22),
				new Person("RamKiranRamKiran", "LaxmiKiran", "sita@gmail.com", 30),
				new Person("RamKiranRamKiran", "Seth", "seth2@gmail.com", 50),
				new Person("SitaSita", "Kumar", "lakshman@gmail.com", 50),
				new Person("GaneshSita", "Kumar", "ganesh@gmail.com", 50));

		Iterable<Person> list = personService.saveAllPersons(personList);
		for (Person person : list) {
			System.out.println("Person Object" + person.toString());

		}
	}


	private void getPersons() {
		List<Integer> personList = new ArrayList<Integer>();
		personList.add(1);
		personList.add(2);
		personList.add(12);
		personList.add(5);
		personList.add(6);
		personList.add(20);
		personList.add(40);
		personList.add(11);
		personList.add(15);
		personList.add(3);
		personList.add(4);
		
		Iterable<Person> personsList = personService.findPersons(personList);
		for (Person person : personsList) {
			System.out.println("Person Object" + person.toString());
		}
	}
}
