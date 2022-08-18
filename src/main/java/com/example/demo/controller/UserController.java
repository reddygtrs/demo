package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.UserRepository;
import com.example.demo.entity.User;

@RestController
//@RequestMapping(value = "/demo", method = RequestMethod.GET)
public class UserController {

	@Autowired
    private UserRepository repo;
	
	@GetMapping("/users")
	public ResponseEntity<String> listAll() {
		ResponseEntity<String> resp = new ResponseEntity<String>(HttpStatus.OK);
		String users = "";
		System.out.println("repo " + repo);
		List<User> listUsers = repo.findAll();
		System.out.println("size " + listUsers.size());
		for(User user : listUsers) {
			users.concat(user.getUsername());
			//System.out.println(user.getUsername());
		}
		return resp.ok(users);
	}
}
