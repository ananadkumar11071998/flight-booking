package demo.service.userservice.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="Tiket_details")
@Getter
@Setter
@NoArgsConstructor

public class Ticket implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long ticketid;

    
    @NotNull
    @Column(name="ticket_no")
    private int  number;
    
    
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JsonBackReference
    private Booking booking;

    @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL)
    @JsonManagedReference
   private List<FlightInstance> flightInstance;
   
 @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL)
  @JsonManagedReference
  private Set<Reservation> reservation;
   
  
  

}
