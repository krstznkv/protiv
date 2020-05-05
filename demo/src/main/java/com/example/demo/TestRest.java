package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestRest {
    private final UserRepository repository;
    @GetMapping("test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("hello");
    }

    @PostMapping("createUser")
    public ResponseEntity<User> testPost(User user) {
        return ResponseEntity.ok(repository.save(user));
    }
}
