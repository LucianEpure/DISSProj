package com.example.DissPr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"entities","controllers"})

public class DissPrApplication {

	public static void main(String[] args) {
		SpringApplication.run(DissPrApplication.class, args);
	}

}
