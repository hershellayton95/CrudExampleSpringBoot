package com.example.CrudTestDemo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CrudTestDemo.entities.User;
import com.example.CrudTestDemo.repositories.UserRepository;


@Service
public class UserService {
	
	@Autowired
	UserRepository ur;

	public String create(User user) {
		ur.saveAndFlush(user);
		return "{\"process\":\"created\"}" ;
	}

	public List<User> getAllUsers() {
		return ur.findAll();
	}

	public User getUserById(long id) {
		Optional<User> user = ur.findById(id);
		return user.get();
	}

	public String modifyUserById(long id, User userRequest) {
		Optional<User> user = ur.findById(id);
		user.get().setUsername(userRequest.getUsername());
		user.get().setLastname(userRequest.getLastname());
		user.get().setAge(userRequest.getAge());
		
		ur.saveAndFlush(user.get());
		
		return "{\"process\":\"updated\"}" ;
	}

	public String delete(long id) {
		ur.delete(ur.findById(id).get());
		return "{\"process\":\"deleted\"}";
	}
}

