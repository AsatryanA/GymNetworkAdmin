package com.example.gym.controller;

import com.example.gym.model.Pool;
import com.example.gym.repository.PoolsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pools")
@RequiredArgsConstructor
public class PoolsController {
    private final PoolsRepository poolsRepository;

    @GetMapping()
    public ResponseEntity<?> getAllPools() {
        return ResponseEntity.status(HttpStatus.OK).body(poolsRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPoolsById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(poolsRepository.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePoolsById(@PathVariable Long id) {
        poolsRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping()
    public ResponseEntity<?> updatePools(@RequestBody Pool pool) {
        return ResponseEntity.status(HttpStatus.OK).body(poolsRepository.save(pool));
    }

    @PostMapping()
    public ResponseEntity<?> insertPools(@RequestBody Pool pool) {
        return ResponseEntity.status(HttpStatus.OK).body(poolsRepository.save(pool));
    }
}
