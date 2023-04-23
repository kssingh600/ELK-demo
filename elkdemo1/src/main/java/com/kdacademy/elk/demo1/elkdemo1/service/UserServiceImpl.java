package com.kdacademy.elk.demo1.elkdemo1.service;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.kdacademy.elk.demo1.elkdemo1.dao.User;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService{

    @Override
    public User findUserById(int id) {
        Predicate<User> userWithId  = user -> user.getId() == id ;
        User user = getAllUsers().stream().filter(userWithId).findAny().orElse(null) ;
        if(user != null){
            log.info("found user: {}", user);
            return user ;
        }
        else{
            try{
                log.info("User not found for the id: {}", id);
                throw new Error() ;
            }
            catch(Exception e){
                e.printStackTrace();
                log.error("user with id, {} not found", id) ;
            }
            return new User() ;
        }
    }

    @Override
    public List<User> getAllUsers() {
        log.info("found list of users");
        return Stream.of(
            new User(1, "Kuldeep Singh"),
            new User(2, "Anmol Singh"),
            new User(3, "Pramod Dubey"),
            new User(4, "Acharya Vinoba Bhave")
        ).collect(Collectors.toList()) ;
    }
   
}
