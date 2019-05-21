package crud.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import crud.demo.model.Person;
import crud.demo.repository.PersonRepository;

@Service
public class PersonService implements PersonServiceInterface {
	@Autowired
	private PersonRepository  personRepo ;
	
	@Override
	public Person create(String firstName,String lastName,int age){
			try {
				System.out.println("dude do you work in verizon");
				return personRepo.save(new Person(firstName,lastName,age));
			} catch (DuplicateKeyException e) {
				System.out.println(e.getMessage());
				return null;
			}
	  }
	
	@Override
	public List<Person> getAll(){
		
		return personRepo.findAll();
	}
	@Override
	public Person getPersonByName(String firstName){
		
		return personRepo.findByFirstName(firstName);
	}
	
	@Override
	public Person update(String firstName,String lastName,int age){
		
		Person temp=personRepo.findByFirstName(firstName);
		temp.setLastName(lastName);
		temp.setAge(age);
		return personRepo.save(temp);
	}
	
	@Override
	public void deleteAll(){
		
		personRepo.deleteAll();
	}
	@Override
	public void deleteByFirstName(String firstName){
		
		Person temp=personRepo.findByFirstName(firstName);
		personRepo.delete(temp);
	}

	@Override
	public int getAgeOfPerson(String lastName) {
		// TODO Auto-generated method stub
		
	       personRepo.findOneByLastName(lastName);
		return 0;
	}
	

}
