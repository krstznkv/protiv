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

    private final UserService userService;

    @PostMapping("registration")
    public ResponseEntity<User> registration(@RequestBody User user) {
        return ResponseEntity.ok(userService.save(user));
    }

    @PostMapping("registrationA")
    public ResponseEntity<User> registrationA(@RequestBody User user) {
        user.setRole(Role.ROLE_ADMIN);
        return ResponseEntity.ok(userService.save(user));
    }

    @PostMapping("/findUser")
    public ResponseEntity<Message> findUser(@RequestBody String username) {
        User u = (User) userService.loadUserByUsername(username);
        if(u==null) return  ResponseEntity.ok(new Message("not found"));
        if (u.getRoles().contains(Role.ROLE_ADMIN))
            return ResponseEntity.ok(new Message("ADMIN"));
        else return ResponseEntity.ok(new Message("USER"));
    }

    @GetMapping("/login")
    public ResponseEntity<Message> authorize() {
        return ResponseEntity.ok(new Message("Success"));
    }
}
