package com.kdacademy.elk.demo1.elkdemo1.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kdacademy.elk.demo1.elkdemo1.dao.User;
import com.kdacademy.elk.demo1.elkdemo1.service.UserService;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private UserService userService ;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("findUserById/{userId}")
    public User findUserById(@PathVariable("userId") Integer id){
        return userService.findUserById(id) ;
    }

    @GetMapping("/getAll")
    public List<User> getAllUsers(){
        return userService.getAllUsers() ;
    }
}
