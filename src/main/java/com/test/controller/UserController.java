package com.test.controller;

import com.test.entity.User;
import com.test.pojo.UserRequest;
import com.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/user")
    public User getUser(Integer id) {
        return userService.getUser(id);
    }

    @PostMapping("/user")
    public User addUser(@RequestBody UserRequest userRequest) {
        return userService.addUser(userRequest);
    }

    @PutMapping("/user")
    public User saveUser(Integer id, @RequestParam(required = false) String username, @RequestParam(required = false) String password, @RequestParam(required = false) Integer age, @RequestParam(required = false) Integer roleID) {
        return userService.saveUser(id, username, password, age, roleID);
    }

    @DeleteMapping("/user")
    public Boolean deleteUser(Integer id) {
        return userService.deleteUser(id);
    }

    @DeleteMapping("/users")
    public Boolean deleteUsers() {
        return userService.deleteUsers();
    }




    @GetMapping("/users2")
    public List<User> selectUsers() {
        return userService.selectUsers();
    }

    @GetMapping("/user2")
    public User selectUser(Integer id) {
        return userService.selectUser(id);
    }

    @GetMapping("/searchusers")
    public List<User> searchUsers(String key) {
        return userService.searchUsers(key);
    }

    @PostMapping("/user2")
    public User insertUser(@RequestBody UserRequest userRequest) {
        return userService.insertUser(userRequest);
    }

    @PutMapping("/user2")
    public User updateUser(Integer id, @RequestParam(required = false) String username, @RequestParam(required = false) String password, @RequestParam(required = false) Integer age, @RequestParam(required = false) Integer roleID) {
        return userService.updateUser(id, username, password, age, roleID);
    }
}
