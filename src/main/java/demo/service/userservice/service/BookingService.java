package demo.service.userservice.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.service.userservice.Exception.ResourceNotFoundException;
import demo.service.userservice.entity.Booking;
import demo.service.userservice.entity.User;
import demo.service.userservice.repository.BookingRepo;
import demo.service.userservice.repository.UserRepository;



@Service
public class BookingService {
	@Autowired
	private BookingRepo bookingRepository;
	
	@Autowired
	private UserRepository userReposiotry;
	
	  
	   
		@SuppressWarnings("unchecked")
		public Set<Booking> getAllBookings() {
	        return (Set<Booking>) bookingRepository.findAll();
	    }

	    
	    public Booking getBookingById(Long booking_id) {
	       return  this.bookingRepository.findById(booking_id).orElseThrow(()->new ResourceNotFoundException("Booking","Booking_id",booking_id));
	        
	    }

	   
	    public Booking createBooking(Booking booking,Long user_id) {
	        User user = this.userReposiotry.findById(user_id).orElseThrow(()->new ResourceNotFoundException("User","user_id",user_id));
	        Booking booking1 = new Booking();
	        booking1.setUser(user);
	        
	        Booking newbooking =this.bookingRepository.save(booking1);
	        return newbooking;
	    }

	    
	    public Booking updateBooking(Booking booking, Long booking_id) {
	        booking.setId(booking_id);
	        return this.bookingRepository.save(booking);
	    }

	    
	    public void deleteBookingById(Long booking_id) {
              this.bookingRepository.deleteById(booking_id);
	    }
}
