package demo.service.userservice.entity;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TicketResponse {
    
	private List<Ticket> content;
	
	private int numberpage;
	
	private int pagesize;
	
	private long totalelement;
	
	private int totalpage;
	
	private boolean lastpage;
}
