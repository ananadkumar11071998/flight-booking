package demo.service.userservice.controller;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import demo.service.userservice.entity.ApiResponse;

import demo.service.userservice.entity.Ticket;
import demo.service.userservice.entity.TicketResponse;
import demo.service.userservice.service.TicketService;

@RestController
@RequestMapping("/ticket")
public class TicketController {
   
	@Autowired
	private TicketService ticektService;
	@PostMapping("/booking/{bookingid}")
    public ResponseEntity<Ticket> createPost(@Valid @RequestBody Ticket ticket,@PathVariable("bookingid") Long id)
    {	
    	Ticket ticket1 = this.ticektService.createTicket(id, ticket);
    	return new ResponseEntity<Ticket>(ticket,HttpStatus.CREATED);
    }
	
	
	@GetMapping("/")
	public ResponseEntity<TicketResponse> getallTicket(@RequestParam(value="pagesize",defaultValue="1",required=false) Integer  pageNumber,
			
			@RequestParam(value="pageNumber",defaultValue="5",required=false) Integer pagesize,
			
			@RequestParam(value ="sortBy", defaultValue="ticketid" ,required=false) String sortBy,
			@RequestParam(value ="sortDir", defaultValue="asc" ,required=false) String sortDir
			
			)
			
			
	{
		
		TicketResponse ticketlist= this.ticektService.getallTicket( pageNumber, pagesize,sortBy,sortDir);
		return new ResponseEntity<TicketResponse>(ticketlist,HttpStatus.OK);
	}
	
	
	@GetMapping("/{ticketid}")
	public ResponseEntity<Ticket> getTicketByid(@PathVariable("ticketid") Long id)
	{
		Ticket ticket1 = this.ticektService.findByTicketid(id);
		
		return new ResponseEntity<Ticket>(ticket1,HttpStatus.OK);
	}
	
	@DeleteMapping("/{ticketid}")
	public ResponseEntity<ApiResponse> deleteTicketById(@PathVariable("ticketid") Long id)
	{
		 this.ticektService.deleteTicketById(id);
		  
		  return  new  ResponseEntity<ApiResponse>(new ApiResponse("user deleted successfully",true),HttpStatus.OK);
	}
	
	 @PutMapping("/{ticketid}")
	  public ResponseEntity<Ticket> updateticket(@Valid @RequestBody Ticket ticket,@PathVariable("ticketid")Long id)
	  {
		  Ticket ticket1 =this.ticektService.updateTicket(ticket, id);
		  return ResponseEntity.ok(ticket1);
		  
	  }
	 @GetMapping("pegiantion/{pageno}/{pagesize}")
	 
	 public ResponseEntity<Page<Ticket>> Ticketpegiantionnadsortiing(@PathVariable int pageno,@PathVariable int pagesize )
	 {
		 Page<Ticket> allticket=this.ticektService.Ticketpegiantionnadsortiing(pageno, pagesize);
		 
		 return ResponseEntity.ok(allticket);
	 }
	 
}
