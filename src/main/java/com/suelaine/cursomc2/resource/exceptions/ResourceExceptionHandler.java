package com.suelaine.cursomc2.resource.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.suelaine.cursomc2.services.exceptions.DataIntegrityException2;
import com.suelaine.cursomc2.services.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound( ObjectNotFoundException e,
			HttpServletRequest request){
		StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(),
				e.getMessage(),System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
		
	} 
	
	@ExceptionHandler(DataIntegrityException2.class)
	public ResponseEntity<StandardError> dataIntegrity( DataIntegrityException2 e,
			HttpServletRequest request){
		StandardError err = new StandardError(HttpStatus.BAD_REQUEST.value(),
				e.getMessage(),System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
		
	} 
	
	

}
