package demo.service.userservice.entity;

import lombok.*;

import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;



@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "User")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, 
property  = "id", 
scope     = Long.class)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message="input your first name")
    @Column(name="UserFirst")
    private String firstName;

    @NotEmpty(message="input your user lastName")
    @Column(name="LastName")
    private String lastName;
    
   @OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
   @JsonManagedReference
   @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
   private Address address;
    
   @OneToMany(mappedBy = "user", cascade = CascadeType.ALL,fetch=FetchType.EAGER)
   @JsonManagedReference
  //@JsonBackReference
   //@JsonIgnore
   private Set<Booking> booking;

}
