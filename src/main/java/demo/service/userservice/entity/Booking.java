package demo.service.userservice.entity;

import java.time.LocalTime;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="ticket_booking")
@Getter
@Setter
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, 
property  = "id", 
scope     = Long.class)
public class Booking {
   
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private LocalTime bookTime;
	
	private boolean isActive;
	
	private boolean isbooked;
	
	 @ManyToOne( cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	 @JoinColumn(name = "user_id" )
     @JsonBackReference
 // @JsonManagedReference
	private User user;
	 
	
	 @OneToMany(mappedBy="booking",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	 @JsonManagedReference
	 private Set<Ticket> ticket;
}
