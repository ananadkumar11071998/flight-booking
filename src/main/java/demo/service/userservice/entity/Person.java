package demo.service.userservice.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Entity(name="Person_Details")
@NoArgsConstructor
public  class Person implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
	
	
    private String firstName;
    
    
    private String lastName;
    
    @NotEmpty
    @Email(message="enter your email")
    private String emailAddress;

    @NotEmpty(message="enter your user name")
    private String username;

    @NotEmpty(message="enter your password")
    @Size(min=4 ,max=7)
    private String password;
    
    @NotEmpty
    @JsonFormat(pattern = "MM/dd/yyyy")
    private LocalDate dateOfBirth;
    
    
   //private Role role;
   
   @ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="ticket_id")
   @JsonBackReference
   private Reservation reservation;

   

}

