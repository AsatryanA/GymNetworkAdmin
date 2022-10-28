package com.example.gym.controller;

import com.example.gym.model.Role;
import com.example.gym.model.User;
import com.example.gym.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/")
    public ResponseEntity<?> getAllUser() {
        return ResponseEntity.status(HttpStatus.OK).body(userRepository.findAll());
    }

    @GetMapping ("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(userRepository.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable Integer id) {
        userRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping()
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.OK).body(userRepository.save(user));
    }

    @PostMapping()
    public ResponseEntity<?> insertUser(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return ResponseEntity.status(HttpStatus.OK).body(userRepository.save(user));
    }
}

