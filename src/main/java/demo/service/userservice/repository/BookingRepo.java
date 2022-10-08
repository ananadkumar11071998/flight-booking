package demo.service.userservice.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import demo.service.userservice.entity.Booking;
import demo.service.userservice.entity.User;

@Repository
@Transactional
public interface BookingRepo extends JpaRepository<Booking,Long> {
	List<Booking> findByUser(User user);
}
