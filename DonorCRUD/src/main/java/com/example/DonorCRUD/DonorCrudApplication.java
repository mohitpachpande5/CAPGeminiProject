package com.example.DonorCRUD;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.DonorCRUD") 
public class DonorCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(DonorCrudApplication.class, args);
	}

}
