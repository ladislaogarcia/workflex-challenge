package com.workflex.challenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	//UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken("user", "password");

}
