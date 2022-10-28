package com.example.gym.controller;

import com.example.gym.model.Wallet;
import com.example.gym.repository.WalletsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/wallets")
@RequiredArgsConstructor
public class WalletsController {
    private final WalletsRepository walletsRepository;
        @GetMapping("/list-wallets/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(walletsRepository.getPyramidById(id));
    }

   @GetMapping("/{id}")
    public ResponseEntity<?> getWalletsById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(walletsRepository.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteWalletsById(@PathVariable Long id) {
        walletsRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping()
    public ResponseEntity<?> updateWallets(@RequestBody Wallet wallet) {
        return ResponseEntity.status(HttpStatus.OK).body(walletsRepository.save(wallet));
    }

    @PostMapping()
    public ResponseEntity<?> insertWallets(@RequestBody Wallet wallet) {
        return ResponseEntity.status(HttpStatus.OK).body(walletsRepository.save(wallet));
    }
}
