package com.example.gym.controller;

import com.example.gym.model.IpVolume;
import com.example.gym.model.LiquidityMining;
import com.example.gym.repository.LiquidityMiningRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/liquidityMining")
@RequiredArgsConstructor
public class LiquidityMiningController {
    private final LiquidityMiningRepository liquidityMiningRepository;

    @GetMapping()
    public ResponseEntity<?> getAllLiquidityMining() {
        return ResponseEntity.status(HttpStatus.OK).body(liquidityMiningRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getLiquidityMiningById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(liquidityMiningRepository.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteLiquidityMiningById(@PathVariable Long id) {
        liquidityMiningRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping()
    public ResponseEntity<?> updateLiquidityMining(@RequestBody LiquidityMining liquidityMining) {
        return ResponseEntity.status(HttpStatus.OK).body(liquidityMiningRepository.save(liquidityMining));
    }

    @PostMapping()
    public ResponseEntity<?> insertLiquidityMining(@RequestBody LiquidityMining liquidityMining) {
        return ResponseEntity.status(HttpStatus.OK).body(liquidityMiningRepository.save(liquidityMining));
    }
}
