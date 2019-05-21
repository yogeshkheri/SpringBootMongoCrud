package crud.demo.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import crud.demo.model.Person;
import crud.demo.service.PersonServiceInterface;

@RestController
public class PersonController {
	@Autowired
	private PersonServiceInterface personService;
	
	
//	@RequestMapping(method=RequestMethod.GET, value="/")
//	public String hello(){
//		return "Hello";
//	}
	
//	@RequestMapping("/create" )
//	public Person createPerson(@RequestParam("firstName")String firstName,@RequestParam("lastName") String lastName, @RequestParam("age") int age ){
//       return personService.create(firstName, lastName, age);		
//	}
	
	@RequestMapping(value="/getAge",method=RequestMethod.GET)
	public ResponseEntity<Integer> getAge(@RequestParam("lastName") String lastName){
		
	int age=	personService.getAgeOfPerson();
	return null;
	}
	
	@RequestMapping(method=RequestMethod.POST , consumes=APPLICATION_JSON_VALUE,produces=APPLICATION_JSON_VALUE,value="/createPost" )
	public ResponseEntity<Person> createPersonProper(@RequestBody Person p ){
       Person obj=personService.create(p.getFirstName(), p.getLastName(), p.getAge());
       if(obj==null){
    	   return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
       }
       else
       {
    	   return ResponseEntity.status(HttpStatus.CREATED).body(obj);
       }
	}
	@RequestMapping(method=RequestMethod.GET, value="/getAll")
	public List<Person> getAll(){
		return personService.getAll();
	}
	@RequestMapping(method=RequestMethod.GET, value="/get")
	public Person getPerson(@RequestParam("firstName") String firstName){
		
		return personService.getPersonByName(firstName);
	}
	@RequestMapping(method=RequestMethod.PUT, value="/update",consumes=APPLICATION_JSON_VALUE, produces=APPLICATION_JSON_VALUE )
	public Person updatePerson(@RequestBody Person obj ){
       return personService.update(obj.getFirstName(), obj.getLastName(), obj.getAge());		
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/delete")
	public String deletePerson(@RequestParam("firstName") String firstName){
		
		 personService.deleteByFirstName(firstName);
	return "Delted "+firstName;
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/deleteAll")
	public String deleteAllPerson(){
		
		 personService.deleteAll();
		 return "All Deleted";
		 		
	}
	
	

}
