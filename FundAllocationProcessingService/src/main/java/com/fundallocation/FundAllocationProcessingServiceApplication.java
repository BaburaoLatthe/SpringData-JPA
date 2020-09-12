package com.fundallocation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EntityScan("com.fundallocation.*")
@EnableTransactionManagement
public class FundAllocationProcessingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FundAllocationProcessingServiceApplication.class, args);
	}

}
