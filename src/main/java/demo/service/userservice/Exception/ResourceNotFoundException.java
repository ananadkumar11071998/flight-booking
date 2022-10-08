package demo.service.userservice.Exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResourceNotFoundException extends RuntimeException{
	String reourceName;
    String fieldName;
    long fieldValue;
	public ResourceNotFoundException(String reourceName, String fieldName, long fieldValue) {
		super(String.format("%s not found  with %s :%s",reourceName,fieldName,fieldValue));
		this.reourceName = reourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
}
