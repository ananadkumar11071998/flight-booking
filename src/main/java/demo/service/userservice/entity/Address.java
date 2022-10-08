package demo.service.userservice.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;



@Entity
@Table(name="user_Address")
@Getter
@Setter
@NoArgsConstructor
public class Address  {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	
	@NotEmpty(message="enter your street name")
    private String street;
	
	@NotEmpty(message="enter your street city")
    private String city;
	
	@NotEmpty(message="enter your street state")
    private String state;
	
	@NotEmpty(message="enter your street zip")
    private String zip;
    
    @OneToOne(mappedBy="address")
    @JsonBackReference
    private User user;
    
   
}
