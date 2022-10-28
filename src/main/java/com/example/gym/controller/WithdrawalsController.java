package com.example.gym.controller;

import com.example.gym.model.Withdrawal;
import com.example.gym.repository.WithdrawalsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/withdrawals")
@RequiredArgsConstructor
public class WithdrawalsController {
    private final WithdrawalsRepository withdrawalsRepository;

    @GetMapping()
    public ResponseEntity<?> getAllWithdrawals() {
        return ResponseEntity.status(HttpStatus.OK).body(withdrawalsRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getWithdrawalsById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(withdrawalsRepository.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteWithdrawalsById(@PathVariable Long id) {
        withdrawalsRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping()
    public ResponseEntity<?> updateWithdrawals(@RequestBody Withdrawal withdrawal) {
        return ResponseEntity.status(HttpStatus.OK).body(withdrawalsRepository.save(withdrawal));
    }

    @PostMapping()
    public ResponseEntity<?> insertWithdrawals(@RequestBody Withdrawal withdrawal) {
        return ResponseEntity.status(HttpStatus.OK).body(withdrawalsRepository.save(withdrawal));
    }
}
