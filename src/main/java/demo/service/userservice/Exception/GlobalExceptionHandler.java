package demo.service.userservice.Exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import demo.service.userservice.entity.ApiResponse;


@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class )
	  public ResponseEntity<ApiResponse> resourceNotFoundHandler(ResourceNotFoundException ex)
	  {
			String massage=ex.getMessage();
			
			ApiResponse apiResponse = new ApiResponse(massage,false);
			
			return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);
	  }
		@ExceptionHandler(MethodArgumentNotValidException.class)
		public ResponseEntity<Map<String,String>> handlemethodArgsNotValidException(MethodArgumentNotValidException ex)
		{
			Map<String,String> resp = new HashMap<String,String>();
			ex.getBindingResult().getAllErrors().forEach((error)->
			{
				String fieldName =( (FieldError)error).getField();
				String message= error.getDefaultMessage();
				resp.put(fieldName, message);
				
			}
					
					);
			return new ResponseEntity<Map<String,String>>(resp,HttpStatus.BAD_REQUEST);
		}
}
