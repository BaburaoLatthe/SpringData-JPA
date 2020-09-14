package com.fundallocation.controlleradvice;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import java.io.IOException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fundallocation.exception.FundAllocationException;

@ControllerAdvice
public class FundAllocationServiceErrorAdvice extends ResponseEntityExceptionHandler {

	private ResponseEntity<Map<String, Object>> error(HttpStatus status, Exception e, Map<String, Object> messageBody) {
		return ResponseEntity.status(status).body(messageBody);
	}

	@ExceptionHandler(value = RuntimeException.class)
	public ResponseEntity<Map<String, Object>> handleRuntimeException(RuntimeException ex) 
	{
		
		Map<String, Object> errorMsgBody = new LinkedHashMap<>();
		errorMsgBody.put("Timestamp", new Date());
		errorMsgBody.put("HttpStatus", HttpStatus.INTERNAL_SERVER_ERROR);
		errorMsgBody.put("Status", "Failed");
		errorMsgBody.put("Error", ex.getMessage());

		return error(INTERNAL_SERVER_ERROR, ex, errorMsgBody);
	}
	
	@ExceptionHandler(value = { FundAllocationException.class })
	public ResponseEntity<Map<String,Object>> handleNotFoundException(FundAllocationException ex)
	{
		Map<String, Object> errorMsgBody = new LinkedHashMap<>();
		
        errorMsgBody.put("Timestamp", new Date());
        errorMsgBody.put("HttpStatus", HttpStatus.NOT_FOUND.toString());
        errorMsgBody.put("Status", "Failed");
        errorMsgBody.put("Error", ex.getMessage());

		return error(NOT_FOUND, ex, errorMsgBody);
	}
	
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request) {

        Map<String, Object> messageBody = new LinkedHashMap<>();
        messageBody.put("Timestamp", new Date());
        messageBody.put("HttpStatus", status.toString());
        messageBody.put("Status", "Failed");

        List<String> errors = ex.getBindingResult()
								                .getFieldErrors()
								                .stream()
								                .map(x -> x.getDefaultMessage())
								                .collect(Collectors.toList());

        messageBody.put("Errors", errors);

        return new ResponseEntity<>(messageBody, headers, status);

    }
    
    @ExceptionHandler(ConstraintViolationException.class)
    public void handleConstraintViolationException(HttpServletResponse response) throws IOException {
		
    	response.sendError(HttpStatus.BAD_REQUEST.value());
    }
}
