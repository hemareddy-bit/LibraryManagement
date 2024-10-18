package com.example.LibraryManagement; // Adjust the package based on your structure

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
// Ensure this matches your package structure
@EnableJpaRepositories(basePackages = "com.example.LibraryManagement.DAO")
public class LibraryManagementApplication {
	public static void main(String[] args) {
		SpringApplication.run(LibraryManagementApplication.class, args);
	}
}
