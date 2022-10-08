package demo.service.userservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.service.userservice.entity.ApiResponse;
import demo.service.userservice.entity.Person;
import demo.service.userservice.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {
	@Autowired
	private PersonService personService;
	
	@PostMapping("/reservation/{reservationid}")
	public ResponseEntity<Person> createReservation(@PathVariable("reservationid") Long id,@Valid @RequestBody Person person)
	
	{
		Person person1 = this.personService.createperson(id, person);
	     return new ResponseEntity<Person>( person1,HttpStatus.CREATED);
	     
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Person> updatePerson(@PathVariable("id") Long id,@Valid @RequestBody Person person)
	
	{
	    Person person1 = this.personService.updatePerson(id, person);
		
		 return ResponseEntity.ok(person1);
	}
	
	@DeleteMapping("/{id}")
	public  ResponseEntity<ApiResponse> deleteReservation(@PathVariable("id") Long id)
	{
		this.personService.deleteById(id);
		
	 return  new  ResponseEntity<ApiResponse>(new ApiResponse("user deleted successfully",true),HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Person>> getAllPerson()
	{
		List<Person> list= this.personService.getAllPerson();
		
		 return ResponseEntity.ok( list);
	}
	
	@GetMapping("/{personid}")
	public ResponseEntity<Person> getPersonbyid(@PathVariable("personid") Long id)
	{
		Person  person= this.personService.getPersonbyid(id);
		
		 return ResponseEntity.ok(person);
	}
	
}
