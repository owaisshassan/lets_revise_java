package com.owaiss.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(UserException.class)
	public ResponseEntity<MyErrorDetails> userExpHandler(UserException ue, WebRequest req){
		
		MyErrorDetails error=new MyErrorDetails();
		error.setTimestamp(LocalDateTime.now());
		error.setMessage(ue.getMessage());
		error.setErrorDesc(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(error, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(EmailException.class)
	public ResponseEntity<MyErrorDetails> emailExpHandler(EmailException ee, WebRequest req){
		
		MyErrorDetails error=new MyErrorDetails();
		error.setTimestamp(LocalDateTime.now());
		error.setMessage(ee.getMessage());
		error.setErrorDesc(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(LoginException.class)
	public ResponseEntity<MyErrorDetails> loginExpHandler(LoginException le, WebRequest req){
		
		MyErrorDetails error=new MyErrorDetails();
		error.setTimestamp(LocalDateTime.now());
		error.setMessage(le.getMessage());
		error.setErrorDesc(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(error, HttpStatus.BAD_GATEWAY);
	}
	
	
	
	///==============generic exceptions:
	
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorDetails> noHandlerFoundExpHandler(NoHandlerFoundException nhfe,WebRequest req)  {
		
		MyErrorDetails error=new MyErrorDetails();
		error.setTimestamp(LocalDateTime.now());
		error.setMessage(nhfe.getMessage());
		error.setErrorDesc(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(error,HttpStatus.BAD_REQUEST);			
	}
	
	
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
