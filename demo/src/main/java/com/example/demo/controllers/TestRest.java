package com.example.demo.controllers;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.repo.UserRepository;
import com.example.demo.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequiredArgsConstructor
public class TestRest {

    private final  UserService userService;

    @GetMapping("test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("hello");
    }

    @PostMapping("createUser")
    public ResponseEntity<User> testPost(User user) {
        user.setRoles(Collections.singleton(Role.ROLE_USER));
        return ResponseEntity.ok(userService.save(user));
    }
}
