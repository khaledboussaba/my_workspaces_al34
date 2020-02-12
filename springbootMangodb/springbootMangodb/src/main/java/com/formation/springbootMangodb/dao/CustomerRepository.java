package com.formation.springbootMangodb.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.formation.springbootMangodb.entity.Person;

public interface CustomerRepository extends MongoRepository<Person, String> {

	public Person findByFirstName(String firstName);
	public List<Person> findByLastName(String lastName);

}
