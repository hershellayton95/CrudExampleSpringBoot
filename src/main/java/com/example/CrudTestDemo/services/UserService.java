package com.example.CrudTestDemo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.CrudTestDemo.entities.User;


@Service
public class UserService {
	
	public static List<User> users = new ArrayList<User>();

	public String create(User user) {
		users.add(user);
		return "{\"process\":\"created\"}" ;
	}

	public List<User> getAllUsers() {
		return users;
	}

	public User getUserById(long id) {
		Optional<User> user = users.stream().filter(item -> item.getId() == id).findFirst();
		return user.get();
	}

	public String modifyUserById(long id, User user) {
		users.stream().filter(item -> item.getId() == id).forEach(item -> setUser(item, user));
		return "{\"process\":\"updated\"}" ;
	}
	
	public void setUser(User item, User user) {
		item.setUsername(user.getUsername());
		item.setLastname(user.getLastname());
		item.setAge(user.getAge());
	}

	public String delete(long id) {
		Optional<User> user = users.stream().filter(item -> item.getId() == id).findFirst();
		users.remove(user.get());
		return "{\"process\":\"deleted\"}";
	}
}

