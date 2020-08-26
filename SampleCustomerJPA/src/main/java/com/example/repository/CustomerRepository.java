package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	@Query("from customer where id = :id")
	public Customer getCustomerId(@Param("id") Integer id);
	
	@Query("from customer where name = :name")
	public Customer getCusomterByName(@Param("name") String name);
	
	@Query(value = "select * from customer where firstname = :firstname", nativeQuery = true)
	public Customer getAllCustomers(@Param(value = "firstname") String firstname);
	
}
