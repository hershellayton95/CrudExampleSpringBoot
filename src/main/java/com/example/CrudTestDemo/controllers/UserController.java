package com.example.CrudTestDemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.CrudTestDemo.entities.User;
import com.example.CrudTestDemo.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public String create(@RequestBody User user){
        return userService.create(user);
    }

    @GetMapping
    public @ResponseBody List<User> getAll(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public @ResponseBody User getById(@PathVariable long id){
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public String update(@PathVariable long id, @RequestBody User user){
    	return userService.modifyUserById(id, user);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable long id){
    	return userService.delete(id);
    }

}
