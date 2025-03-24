package com.example;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class DockerQapApplication {
	public static void main(String[] args) {
		SpringApplication.run(DockerQapApplication.class, args);
	}

}
