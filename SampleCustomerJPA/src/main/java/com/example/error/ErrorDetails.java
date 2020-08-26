package com.example.error;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;

public class ErrorDetails {
	
	private LocalDate timestamp;
	
	private HttpStatus status;
	
	private String description;
	
	public ErrorDetails(LocalDate localDate, HttpStatus notFound, String description) {
		super();
		this.timestamp = localDate;
		this.status = notFound;
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	public LocalDate getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDate timestamp) {
		this.timestamp = timestamp;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
