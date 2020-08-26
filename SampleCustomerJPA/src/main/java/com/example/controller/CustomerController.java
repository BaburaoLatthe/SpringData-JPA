package com.example.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Customer;
import com.example.service.CustomerService;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping(value = "/fetch/{firstname}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Customer getCustomers(@PathVariable String firstname,
									   @RequestParam(name = "customerId", required = false) String id)
	{
		return customerService.getCustomer(firstname);
	}
	
	@GetMapping(value = "/fetch/all")
	public List<Customer> fetchAllCustomers(){
		return customerService.getAllCustomer();
	}
 	
	@PostMapping(value = "/add")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
		Customer addCustomer = customerService.addCustomer(customer);
		
		return new ResponseEntity<>(addCustomer, HttpStatus.CREATED);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<HttpStatus> delteCustomer(@PathVariable Integer id){
		customerService.removeCustomer(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping(value = "/id/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable Integer id) {
		 Customer singleCusomter = customerService.getSingleCusomter(id);
		 return new ResponseEntity<Customer>(singleCusomter,HttpStatus.OK);
	}

	@GetMapping(value = "/fetch/name/{name}")
	public ResponseEntity<Customer> getCustomerByName(@PathVariable("name") String name){
		Customer customerByName = customerService.getCustomerByName(name);
		return new ResponseEntity<>(customerByName, HttpStatus.OK);
	}
}
