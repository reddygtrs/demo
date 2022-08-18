package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class GetUser implements CommandLineRunner{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public void run(String... args) throws Exception {
		String sql = "INSERT INTO sys.user (id, username, email, password) VALUES (?, ?, ?, ?)";
		int result = 1;//jdbcTemplate.update(sql, 102, "reddygtrs", "welcome123", "reddygtrs@yahoo.com");
		if(result > 0) {
			System.out.println("record successfully inserted");
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(GetUser.class, args);
	}
}
