package demo.service.userservice.controller;



import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.service.userservice.entity.Booking;
import demo.service.userservice.service.BookingService;

@RestController
@RequestMapping("/booking")
public class BookingController {
	@Autowired
	private BookingService bookingService;
	@PostMapping("/user/{userid}")
    public ResponseEntity<Booking> createPost(@Valid @RequestBody Booking booking,@PathVariable("userid") Long userid)
    {	
    	Booking booking1 = this.bookingService.createBooking(booking,userid);
    	return new ResponseEntity<Booking>(booking1,HttpStatus.CREATED);
    }
	
	
	@GetMapping("/")
	public ResponseEntity<Set<Booking>> getPostByCategory()
	{
		Set<Booking> bookinglist= this.bookingService.getAllBookings();
		
		return new ResponseEntity<Set<Booking>>(bookinglist,HttpStatus.OK);
	}
	
	
}
