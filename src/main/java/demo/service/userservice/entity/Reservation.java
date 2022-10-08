package demo.service.userservice.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="Reservation_Details")
@Getter
@Setter
@NoArgsConstructor
public class Reservation implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private long reservationid;
    
	@NotNull
    private long reservationNumber;
	
	@NotEmpty(message="enter your code")
    private String code;
	
	@NotEmpty(message="enter your departure")
    private String departure;

	@NotEmpty(message="enter your destiantion")
    private String destination;

   // private Status status = Status.PENDING;

	@NotNull
    private Double reserveAmount;

	@NotEmpty(message="enter your reservedBy")
    private String reserveBy;

	@NotEmpty(message="enter your type")
    private String type;
    
   // private Person agent;

    @OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Person> person;

  
  @ManyToOne(fetch=FetchType.LAZY)
  @JsonBackReference
  @JoinColumn(name="ticket_id")
   private Ticket ticket;

   public Reservation(
            String code,
            @NonNull String departure,
            Person agent,
            @NonNull String destination,
            Person person,
            String reserveBy
    ) {
        this.code = code;
        this.departure = departure;
        this.destination = destination;
        this.reserveAmount = 0.0;
       // this.agent = agent;
        this.reserveBy = reserveBy;
        //this.person = person;
    }
    
}
