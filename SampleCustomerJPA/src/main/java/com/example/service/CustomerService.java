package com.example.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.error.CustomerNotFoundException;
import com.example.model.Customer;
import com.example.repository.CustomerRepository;

@Service
public class CustomerService {
	
	Logger loggerFactory = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CustomerRepository custRepository;
	
	public Customer getCustomer(String firstname) {
		
		List<Customer> allCustomers = custRepository.findAll();
		return allCustomers.stream()
									.filter(cust -> firstname.equalsIgnoreCase(cust.getName()))
									.findFirst()
									.orElseThrow(() -> new CustomerNotFoundException(firstname+" As a customer Does not Exist"));
	}
	
	public List<Customer> getAllCustomer(){
		return custRepository.findAll();
	}
	
	public Customer addCustomer(Customer customer) {
		loggerFactory.debug("Customer  "+customer);
		return custRepository.save(customer);
	}
	
	public void removeCustomer(Integer id) {
		custRepository.deleteById(id);
	}
	
	public Customer getSingleCusomter(Integer id) {
		return custRepository.getCustomerId(id);
	}

	public Customer getCustomerByName(String name){
		Optional<Customer> optional = Optional.of(custRepository.getCusomterByName(name));
		
		if(optional.isPresent())
			return optional.get();
		else
			throw new CustomerNotFoundException(name+" As a customer Does not Exist");
	}
}
