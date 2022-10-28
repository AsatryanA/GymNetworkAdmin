package com.example.gym.controller;

import com.example.gym.model.Referral;
import com.example.gym.repository.ReferralsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/referrals")
@RequiredArgsConstructor
public class ReferralsController {
    private final ReferralsRepository referralsRepository;

    @GetMapping()
    public ResponseEntity<?> getAllReferrals() {
        return ResponseEntity.status(HttpStatus.OK).body(referralsRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getReferralsById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(referralsRepository.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteReferralsById(@PathVariable Long id) {
        referralsRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping()
    public ResponseEntity<?> updateReferrals(@RequestBody Referral referral) {
        return ResponseEntity.status(HttpStatus.OK).body(referralsRepository.save(referral));
    }

    @PostMapping()
    public ResponseEntity<?> insertReferrals(@RequestBody Referral referral) {
        return ResponseEntity.status(HttpStatus.OK).body(referralsRepository.save(referral));
    }
}
