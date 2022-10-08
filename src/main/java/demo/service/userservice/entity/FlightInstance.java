package demo.service.userservice.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name="FlightInstance_detauils")
@Getter
@Setter
@NoArgsConstructor
public class FlightInstance implements Serializable {
	
	private static final long serialVersionUID = 1L;

    @Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
    private long id;

	
	private String flightName;
	
    private LocalTime departureTime;
    
    private LocalTime arrivalTime;
    
    private LocalDate departureDate;
    
    private LocalDate arrivalDate;
    
    private Long flightId;
    
    private double amount;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name="ticket_id")
    private Ticket ticket;
    
    

}
