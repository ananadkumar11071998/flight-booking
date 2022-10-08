package demo.service.userservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import demo.service.userservice.entity.FlightInstance;
import demo.service.userservice.service.FlightInstanceService;

@RestController()
@RequestMapping("/flight")
public class FlightInstanceController {
     @Autowired
	private FlightInstanceService flightInstanceService;
	
	
	@PostMapping("/ticket/{ticketid}")
	public ResponseEntity<FlightInstance> createReservation(@PathVariable("ticketid") Long id,@RequestBody FlightInstance flightInstance)
	
	{
		FlightInstance flight = this.flightInstanceService.createFlightInstance(id, flightInstance);
	     return new ResponseEntity<FlightInstance>( flight,HttpStatus.CREATED);
	     
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<FlightInstance> updateReservation(@PathVariable("id") Long id, @RequestBody FlightInstance flightInstance)
	
	{
		FlightInstance flight = this.flightInstanceService.updateFlightInstance(id, flightInstance);
		
		 return ResponseEntity.ok(flight);
	}
	
	@DeleteMapping("/{id}")
	public  ResponseEntity<ApiResponse> deleteReservation(@PathVariable("id") Long id)
	{
		this.flightInstanceService.deleteById(id);
		
	 return  new  ResponseEntity<ApiResponse>(new ApiResponse("user deleted successfully",true),HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<FlightInstance>> getAllReservation()
	{
		List<FlightInstance> list= this.flightInstanceService.getAllFlightInstance();
		
		 return ResponseEntity.ok( list);
	}
	
	@GetMapping("/{flightid}")
	public ResponseEntity<FlightInstance> getreservationbyid(@PathVariable("flightid") Long id)
	{
		FlightInstance flight= this.flightInstanceService.getflightInstancebyid(id);
		
		 return ResponseEntity.ok(flight);
	}
	
	//search flight by name
	@GetMapping("/flightName")
	public ResponseEntity<List<FlightInstance>> searchfbyNameflight(@RequestParam String flightName)
	{
		List<FlightInstance> flightByName = this.flightInstanceService.searchfbyNameflight(flightName);
		
		return ResponseEntity.ok(flightByName);
	}
}
