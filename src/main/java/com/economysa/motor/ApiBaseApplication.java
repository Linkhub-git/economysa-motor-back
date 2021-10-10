package com.economysa.motor;

import com.economysa.motor.app.security.entity.User;
import com.economysa.motor.app.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.jdbc.Sql;

import java.util.Date;

@SpringBootApplication
public class ApiBaseApplication implements CommandLineRunner {

	@Autowired private UserRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(ApiBaseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*User user = new User();
		user.setId(1L);
		user.setEmail("jcieza90@gmail.com");
		user.setPassword("{bcrypt}$2a$10$51VMRmGqcLqojqXkZFFwIufc7trvCmTp/dDVmeBSTUVZoQhrEB/YK");
		user.setRole("ROLE_USER");
		user.setName("Jeferson");
		user.setLastName("Cieza");
		user.setPhone("983552193");
		user.setCreationDate(new Date());
		user.setStatus(Boolean.TRUE);
		repository.save(user);*/
	}
}
