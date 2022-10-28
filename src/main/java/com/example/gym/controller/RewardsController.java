package com.example.gym.controller;

import com.example.gym.model.Reward;
import com.example.gym.repository.RewardsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rwards")
@RequiredArgsConstructor
public class RewardsController {
    private final RewardsRepository rewardsRepository;

    @GetMapping()
    public ResponseEntity<?> getAllRewards() {
        return ResponseEntity.status(HttpStatus.OK).body(rewardsRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getRewardsById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(rewardsRepository.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRewardsById(@PathVariable Long id) {
        rewardsRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping()
    public ResponseEntity<?> updateRewards(@RequestBody Reward reward) {
        return ResponseEntity.status(HttpStatus.OK).body(rewardsRepository.save(reward));
    }

    @PostMapping()
    public ResponseEntity<?> insertRewards(@RequestBody Reward reward) {
        return ResponseEntity.status(HttpStatus.OK).body(rewardsRepository.save(reward));
    }
}
