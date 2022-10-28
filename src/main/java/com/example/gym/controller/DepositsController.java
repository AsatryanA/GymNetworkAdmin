package com.example.gym.controller;

import com.example.gym.model.Deposit;
import com.example.gym.repository.DepositsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/deposits")
@RequiredArgsConstructor
public class DepositsController {
    private final DepositsRepository depositsRepository;

    @GetMapping()
    public ResponseEntity<?> getAllDeposits() {
        return ResponseEntity.status(HttpStatus.OK).body(depositsRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDepositsById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(depositsRepository.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDepositsById(@PathVariable Long id) {
        depositsRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping()
    public ResponseEntity<?> updateDeposits(@RequestBody Deposit deposit) {
        return ResponseEntity.status(HttpStatus.OK).body(depositsRepository.save(deposit));
    }

    @PostMapping()
    public ResponseEntity<?> insertDeposits(@RequestBody Deposit deposit) {
        return ResponseEntity.status(HttpStatus.OK).body(depositsRepository.save(deposit));
    }
}
