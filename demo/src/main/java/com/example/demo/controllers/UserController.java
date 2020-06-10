package com.example.demo.controllers;

import com.example.demo.entity.Message;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final  UserService userService;

    @GetMapping("test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("hello");
    }

    @PostMapping("registration")
    public ResponseEntity<User> registration(@RequestBody User user) {
        user.setRoles(Collections.singleton(Role.ROLE_USER));
        return ResponseEntity.ok(userService.save(user));
    }
    @GetMapping("/login")
    public ResponseEntity<Message>  authorize()
    {
        return ResponseEntity.ok(new Message("Success"));
    }
}
