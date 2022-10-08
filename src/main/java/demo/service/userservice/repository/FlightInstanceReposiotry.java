package demo.service.userservice.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import demo.service.userservice.entity.FlightInstance;

@Repository
@Transactional
public interface FlightInstanceReposiotry extends JpaRepository<FlightInstance,Long>{
	

	List<FlightInstance> findByflightNameLike(String flightName);
	 
	
}
