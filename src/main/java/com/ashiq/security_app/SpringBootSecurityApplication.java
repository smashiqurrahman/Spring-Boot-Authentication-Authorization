package com.ashiq.security_app;

import com.ashiq.security_app.auth.AuthenticationService;
import com.ashiq.security_app.auth.RegisterRequest;
import com.ashiq.security_app.user.Role;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static com.ashiq.security_app.user.Role.ADMIN;
import static com.ashiq.security_app.user.Role.MANAGER;

@SpringBootApplication
public class SpringBootSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityApplication.class, args);
		System.out.println("Spring boot application started...!");
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			AuthenticationService authenticationService
	){
		return args -> {
			var admin = RegisterRequest.builder()
					.firstname("Admin")
					.lastname("Admin")
					.email("admin@mail.com")
					.password("password")
					.role(ADMIN)
					.build();
			System.out.println("Admin token: " + authenticationService.register(admin).getAccessToken());

			var manager = RegisterRequest.builder()
					.firstname("Admin")
					.lastname("Admin")
					.email("manager@mail.com")
					.password("password")
					.role(MANAGER)
					.build();
			System.out.println("Manager token: " + authenticationService.register(manager).getAccessToken());

		};
	}
}
