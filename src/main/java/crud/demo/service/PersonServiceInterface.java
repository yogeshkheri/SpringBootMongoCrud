package crud.demo.service;

import java.util.List;

import crud.demo.model.Person;


public interface PersonServiceInterface {

	Person create(String firstName, String lastName, int age);

	List<Person> getAll();

	Person getPersonByName(String firstName);

	Person update(String firstName, String lastName, int age);

	void deleteByFirstName(String firstName);

	void deleteAll();

	int getAgeOfPerson();

	int getAgeOfPerson(String lastName);

}
