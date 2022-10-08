package demo.service.userservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import demo.service.userservice.entity.Booking;
import demo.service.userservice.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket,Long>{
      List<Ticket> findByBooking(Booking booking);
}
