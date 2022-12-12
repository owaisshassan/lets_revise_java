package com.owaiss.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


@ControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(StudentException.class)
	public ResponseEntity<MyErrorDetails> userExpHandler(StudentException ue, WebRequest req){
		
		MyErrorDetails error=new MyErrorDetails();
		error.setTimestamp(LocalDateTime.now());
		error.setMessage(ue.getMessage());
		error.setErrorDesc(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(error, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(CourseException.class)
	public ResponseEntity<MyErrorDetails> userExpHandler(CourseException ee, WebRequest req){
		
		MyErrorDetails error=new MyErrorDetails();
		error.setTimestamp(LocalDateTime.now());
		error.setMessage(ee.getMessage());
		error.setErrorDesc(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(AdminException.class)
	public ResponseEntity<MyErrorDetails> userExpHandler(AdminException le, WebRequest req){
		
		MyErrorDetails error=new MyErrorDetails();
		error.setTimestamp(LocalDateTime.now());
		error.setMessage(le.getMessage());
		error.setErrorDesc(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(error, HttpStatus.BAD_GATEWAY);
	}
	
	
	
	///==============generic exceptions:
	
	

	
	
	@ExceptionHandler(NoSuchMethodException.class)
	public ResponseEntity<MyErrorDetails> noSuchMethodExceptionHandler(NoSuchMethodException nsme, WebRequest req){
		
		MyErrorDetails error=new MyErrorDetails();
		error.setTimestamp(LocalDateTime.now());
		error.setMessage(nsme.getMessage());
		error.setErrorDesc(req.getDescription(false));
		
		
		return new ResponseEntity<MyErrorDetails>(error, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> allExceptionsHandler(Exception e,WebRequest req){
		
		MyErrorDetails error = new MyErrorDetails();
		error.setTimestamp(LocalDateTime.now());
		error.setMessage(e.getMessage());
		error.setErrorDesc(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(error,HttpStatus.BAD_REQUEST);
	}

}
