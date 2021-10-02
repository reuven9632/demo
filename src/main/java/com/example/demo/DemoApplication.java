package com.example.demo;

import com.example.demo.AtestCodeAndFitches.declarativeProgrammingStream.DeclarativeProgramming;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		DeclarativeProgramming declarativeProgramming = new DeclarativeProgramming();
		declarativeProgramming.streamFunction();
	}

}
