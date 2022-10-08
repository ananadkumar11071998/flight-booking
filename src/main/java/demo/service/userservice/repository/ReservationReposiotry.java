package demo.service.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import demo.service.userservice.entity.Reservation;

@Repository
@Transactional
public interface ReservationReposiotry  extends JpaRepository<Reservation,Long>{

}
