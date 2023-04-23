package com.kdacademy.elk.demo1.elkdemo1.service;

import java.util.List;

import com.kdacademy.elk.demo1.elkdemo1.dao.User;

public interface UserService {

    public User findUserById(int id) ;

    public List<User> getAllUsers() ;

}
