package com.revature.P1DemoBackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan("com.revature.models") //Tells Spring to scan this package for DB entites
@ComponentScan("com.revature") //Tells spring to scan this package for beans
public class P1DemoBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(P1DemoBackendApplication.class, args);

		System.out.println("Video Game Management App is running.");

	}

}
