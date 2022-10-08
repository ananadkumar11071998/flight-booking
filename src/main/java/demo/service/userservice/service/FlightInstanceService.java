package demo.service.userservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.service.userservice.Exception.ResourceNotFoundException;
import demo.service.userservice.entity.FlightInstance;
import demo.service.userservice.entity.Ticket;
import demo.service.userservice.repository.FlightInstanceReposiotry;
import demo.service.userservice.repository.TicketRepository;

@Service
public class FlightInstanceService {
	
	@Autowired
	private FlightInstanceReposiotry  flightInstanceRepo;
	
	@Autowired
	private TicketRepository  ticketReposiotry ;

	public  FlightInstance createFlightInstance(Long ticketid, FlightInstance  flightInstance)
	{
		Ticket ticket = this.ticketReposiotry.findById(ticketid).orElseThrow(()->new ResourceNotFoundException("ticket","ticketid",ticketid));
		flightInstance.setTicket(ticket);
		
		return this.flightInstanceRepo.save(flightInstance);
	}
	
	
	
	
	public List<FlightInstance > getAllFlightInstance()
	{
		return this.flightInstanceRepo.findAll();
	}
	
	
	public FlightInstance  getflightInstancebyid(Long id)
	{
		return this.flightInstanceRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("flight","flightid",id));
	}
	
	
	public FlightInstance updateFlightInstance(Long id,FlightInstance flightInstance)
	{
		
		FlightInstance flightInstance1 = this.flightInstanceRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("FlightInstance","FlightInstanceid",id));
	    
		flightInstance.setFlightId(id);;
		
		return this.flightInstanceRepo.save(flightInstance1);
	}
	
	public void deleteById(Long id)
	{
		this.flightInstanceRepo.deleteById(id);
	}
	
	// search flight by name
	public List<FlightInstance>	searchfbyNameflight(String flightName)
	{
		List<FlightInstance> list = this.flightInstanceRepo.findByflightNameLike("%"+flightName+"%");
		
		return list;
	}
	
}
