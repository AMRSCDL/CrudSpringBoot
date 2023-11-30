package com.amir.crudapp.controller;

import com.amir.crudapp.entity.User;
import com.amir.crudapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }
    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id){
        return userService.getById(id);
    }
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user){
        return userService.updateUserById(id, user);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id){
        return " Kullanıcı silindi: " + userService.deleteUserById(id);
    }
}
