package com.cursrespring.curser.controllers;

import com.cursrespring.curser.entities.User;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class UserController {
    @GetMapping
    public ResponseEntity<User> findALL(){
        User u = new User(1L,"Maria","m aria@gmail.com","999999999","12345");
        return ResponseEntity.ok().body(u);

    }
}
