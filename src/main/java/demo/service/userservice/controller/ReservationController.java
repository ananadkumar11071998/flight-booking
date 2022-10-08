package demo.service.userservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.service.userservice.entity.ApiResponse;
import demo.service.userservice.entity.Reservation;
import demo.service.userservice.service.ReservationService;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
    @Autowired  
	private ReservationService reservationService;
	
	@PostMapping("/ticket/{ticketid}")
	public ResponseEntity<Reservation> createReservation(@PathVariable("ticketid") Long id,@Valid @RequestBody Reservation reservation)
	
	{
	     Reservation reservation1 = this.reservationService.createReservation(id, reservation);
	     return new ResponseEntity<Reservation>( reservation1,HttpStatus.CREATED);
	     
	}
	
	@PutMapping("/{reservationid}")
	public ResponseEntity<Reservation> updateReservation(@PathVariable("reservationid") Long id,@Valid @RequestBody Reservation reservation)
	
	{
		Reservation reservation1 = this.reservationService.updateReservation(id, reservation);
		
		 return ResponseEntity.ok(reservation1);
	}
	
	@DeleteMapping("/{reservationid}")
	public  ResponseEntity<ApiResponse> deleteReservation(@PathVariable("reservationid") Long id)
	{
		this.reservationService.deleteById(id);
		
	 return  new  ResponseEntity<ApiResponse>(new ApiResponse("user deleted successfully",true),HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Reservation>> getAllReservation()
	{
		List<Reservation> list= this.reservationService.getAllReservation();
		
		 return ResponseEntity.ok( list);
	}
	
	@GetMapping("/{reservationid}")
	public ResponseEntity<Reservation> getreservationbyid(@PathVariable("reservationid") Long id)
	{
	    Reservation reservationid= this.reservationService.getreservationbyid(id);
		
		 return ResponseEntity.ok( reservationid);
	}
 }
