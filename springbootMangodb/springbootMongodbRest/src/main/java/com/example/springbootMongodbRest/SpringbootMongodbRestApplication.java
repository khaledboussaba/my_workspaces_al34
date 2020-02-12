package com.example.springbootMongodbRest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.springbootMongodbRest.dao.PersonRepository;
import com.example.springbootMongodbRest.entity.Person;

@SpringBootApplication
public class SpringbootMongodbRestApplication implements CommandLineRunner {

	@Autowired
	private PersonRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootMongodbRestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repository.deleteAll();

		// save a couple of persons
		repository.save(new Person("Alice", "Smith"));
		repository.save(new Person("Bob", "Smith"));

		// fetch all persons
		System.out.println("Persons found with findAll():");
		System.out.println("-------------------------------");
		
		for (Person customer : repository.findAll()) {
			System.out.println(customer);
		}
		System.out.println();

		System.out.println("Persons found with findByLastName('Smith'):");
		System.out.println("--------------------------------");
		for (Person person : repository.findByLastName("Smith")) {
			System.out.println(person);
		}
		
	}

}
