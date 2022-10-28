package com.example.gym.controller;

import com.example.gym.model.Balance;
import com.example.gym.repository.BalanceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/balance")
@RequiredArgsConstructor
public class BalanceController {
    private final BalanceRepository balanceRepository;

    @GetMapping()
    public ResponseEntity<?> getAllBalance() {
        return ResponseEntity.status(HttpStatus.OK).body(balanceRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBalanceById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(balanceRepository.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBalanceById(@PathVariable Long id) {
        balanceRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping()
    public ResponseEntity<?> updateBalance(@RequestBody Balance balance) {
        return ResponseEntity.status(HttpStatus.OK).body(balanceRepository.save(balance));
    }

    @PostMapping()
    public ResponseEntity<?> insertBalance(@RequestBody Balance balance) {
        return ResponseEntity.status(HttpStatus.OK).body(balanceRepository.save(balance));
    }
}
