package com.example.CrudTestDemo.entities;

import org.springframework.stereotype.Component;

@Component
public class User {

    private long id;
    private String username;
    private String lastname;
    private int age;
    
    public User() {}
    
	public User(long id, String username, String lastname, int age) {
		this.id = id;
		this.username = username;
		this.lastname = lastname;
		this.age = age;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
  
}
