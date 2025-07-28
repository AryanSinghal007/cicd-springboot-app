package com.cicd.cicd_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class CicdProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CicdProjectApplication.class, args);
	}

	@RestController
	public class HelloController {
		@GetMapping("/")
		public String hello() {
			return "Hello from CI/CD!";
		}
	}
}
