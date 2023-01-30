package com.example.refugio;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.example.refugio.repository")
@EntityScan("com.example.refugio.model")
public class AnimalShelter {

	public static void main(String[] args) {
		SpringApplication.run(AnimalShelter.class, args);
	}

}
