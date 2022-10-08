package demo.service.userservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.service.userservice.Exception.ResourceNotFoundException;
import demo.service.userservice.entity.Reservation;
import demo.service.userservice.entity.Ticket;
import demo.service.userservice.repository.ReservationReposiotry;
import demo.service.userservice.repository.TicketRepository;

@Service
public class ReservationService {
     
	@Autowired
	private ReservationReposiotry reservationRepo;
	
	@Autowired
	private TicketRepository ticketRepo;
	
	public Reservation createReservation(Long ticketid,Reservation reservation)
	{
		Ticket ticket= this.ticketRepo.findById(ticketid).orElseThrow(()->new ResourceNotFoundException("Ticket","Ticketid", ticketid));
		reservation.setTicket(ticket);;
		
		return this.reservationRepo.save(reservation);
		
	}
	
	public List<Reservation> getAllReservation()
	{
		return this.reservationRepo.findAll();
	}
	
	public Reservation getreservationbyid(Long reservationid)
	{
		return this.reservationRepo.findById(reservationid).orElseThrow(()->new ResourceNotFoundException("Reservation","reservationid",reservationid));
	}
	
	public Reservation updateReservation(Long reservationid,Reservation reservation)
	{
		
		Reservation reservation1 = this.reservationRepo.findById(reservationid).orElseThrow(()->new ResourceNotFoundException("Reservation","reservationid",reservationid));
	    
		reservation.setReservationid(reservationid);
		
		return this.reservationRepo.save(reservation);
	}
	
	public void deleteById(Long reservationid)
	{
		this.reservationRepo.deleteById(reservationid);
	}
	
	
	
}
