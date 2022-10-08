package demo.service.userservice.service;


import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import demo.service.userservice.Exception.ResourceNotFoundException;
import demo.service.userservice.entity.Booking;
import demo.service.userservice.entity.Ticket;
import demo.service.userservice.entity.TicketResponse;
import demo.service.userservice.repository.BookingRepo;
import demo.service.userservice.repository.TicketRepository;

@Service
public class TicketService {
  
	@Autowired
	 private BookingRepo bookingRepo;
	
	@Autowired
	private TicketRepository ticketReposiotry;
	
	public Ticket createTicket(Long bookingid,Ticket ticket)
{
		
	Booking booking = this.bookingRepo.findById(bookingid).orElseThrow(()->new ResourceNotFoundException("booking","bookingid",bookingid));
    ticket.setBooking(booking);
    return this.ticketReposiotry.save(ticket);
}
	
	
	public TicketResponse getallTicket(Integer pageNumber,Integer pagesize,String sortBy,String sortDir)
	{
	   Sort sort=(sortDir.equalsIgnoreCase("asc"))?Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
      
	 /* if(sortDir.equalsIgnoreCase("asc"))
      {
    	  sort= Sort.by(sortBy).ascending();
      }else
      {
    	  sort= Sort.by(sortBy).descending();
      }
		
	 */	 
		//Pageable p=  PageRequest.of(  pageNumber, pagesize,Sort.by(sortBy).descending());
      
      Pageable p=  PageRequest.of(  pageNumber, pagesize,sort)
    		  ;
		Page<Ticket> page =this.ticketReposiotry.findAll(p);
		List<Ticket> allticket= page.getContent();
		
		TicketResponse ticketResponse = new TicketResponse();
		ticketResponse.setContent(allticket);
		ticketResponse.setNumberpage(page.getNumber());
		ticketResponse.setPagesize(page.getSize());
	    ticketResponse.setTotalelement(page.getNumberOfElements());
	    ticketResponse.setTotalpage(page.getTotalPages());
	    ticketResponse.setLastpage(page.isLast());
		return  ticketResponse ;
	}
	
	public Ticket findByTicketid(Long ticketid)
	{
		Ticket ticket= this.ticketReposiotry.findById(ticketid).orElseThrow(()->new ResourceNotFoundException("ticket","ticketid",ticketid));
		return ticket;
		
		
		
	}
	
	
	public Ticket updateTicket(Ticket ticket,Long id)
	{
		ticket.setTicketid(id);
		return this.ticketReposiotry.save(ticket);
	}
	
	public  void deleteTicketById(Long id)
	{
		this.ticketReposiotry.deleteById(id);
	}
	
	public Page<Ticket> Ticketpegiantionnadsortiing(int pageno, int pageSize)
	{
	   Page<Ticket> tickets=this.ticketReposiotry.findAll(PageRequest.of(pageno, pageSize));
	   
	   return tickets;
	   
	}
}
