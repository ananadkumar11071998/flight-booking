package demo.service.userservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.service.userservice.Exception.ResourceNotFoundException;
import demo.service.userservice.entity.Person;
import demo.service.userservice.entity.Reservation;
import demo.service.userservice.repository.PersonRepository;
import demo.service.userservice.repository.ReservationReposiotry;

@Service
public class PersonService {
    
	@Autowired
	private PersonRepository personRepo;
	
	@Autowired
	private ReservationReposiotry  reservationRepo;
	

	public  Person createperson(Long reservationid, Person  person)
	{
		Reservation reservation = this.reservationRepo.findById( reservationid).orElseThrow(()->new ResourceNotFoundException("ticket","reservationid", reservationid));
		person.setReservation(reservation);
		
		return this.personRepo.save(person);
	}
	
	
	
	
	public List<Person> getAllPerson()
	{
		return this.personRepo.findAll();
	}
	
	
	public Person  getPersonbyid(Long personid)
	{
		return this.personRepo.findById(personid).orElseThrow(()->new ResourceNotFoundException("person","personid",personid));
	}
	
	
	public  Person updatePerson(Long id, Person person)
	{
		
		Person person1 = this.personRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("person","personid",id));
	    
		person.setId(id);;;
		
		return this.personRepo.save(person1);
	}
	
	public void deleteById(Long id)
	{
		this.personRepo.deleteById(id);
	}
}
