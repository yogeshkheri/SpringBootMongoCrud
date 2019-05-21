package crud.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import crud.demo.model.Person;
@Repository
public interface PersonRepository extends MongoRepository<Person, String> {
	
   public	List<Person> findByAge(int age);
   @Query(value="{ firstName : ?0}",fields="{age:0}")
   public Person findByFirstName(String firstName);
   public Person findOneByLastName(String lastName);

}
