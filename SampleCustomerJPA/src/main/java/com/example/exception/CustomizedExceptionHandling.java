package com.example.exception;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.error.CustomerNotFoundException;
import com.example.error.ErrorDetails;

@RestControllerAdvice
public class CustomizedExceptionHandling extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(CustomerNotFoundException.class)
	public final ResponseEntity<ErrorDetails> handleCustomerNotFoundException(CustomerNotFoundException ex, WebRequest request) {
		
		ErrorDetails error = new ErrorDetails(LocalDate.now(), HttpStatus.NOT_FOUND, ex.getMessage());
		
		return new ResponseEntity<ErrorDetails>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = {RuntimeException.class})
	public final ResponseEntity<ErrorDetails> handleAllException(RuntimeException ex, WebRequest request) {
		
		ErrorDetails error = new ErrorDetails(LocalDate.now(),HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
		
		return new ResponseEntity<ErrorDetails>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
