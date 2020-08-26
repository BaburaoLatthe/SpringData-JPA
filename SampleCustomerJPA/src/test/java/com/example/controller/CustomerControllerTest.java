package com.example.controller;

import static org.assertj.core.api.Assertions.assertThatObject;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.model.Customer;
import com.example.service.CustomerService;

@ExtendWith(value = SpringExtension.class)
@SpringBootTest(classes = {CustomerController.class})
class CustomerControllerTest {
	
	@Autowired
	private CustomerController custom;
	
	@MockBean
	private CustomerService service;
	
	private Customer customer = new Customer();
	
	@BeforeEach
	private void setUp() {
		customer.setId(1);
		customer.setName("Baburao");
	}
	
	@Test
	void getCustomersTest() {
		when(service.getCustomer(Mockito.anyString())).thenReturn(customer);
		Customer actualCustomer = custom.getCustomers("Baburao", "2");
		assertThatObject(actualCustomer).matches(e -> e.getName().equalsIgnoreCase("Baburao"));
	}
}
