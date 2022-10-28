package com.example.gym.controller;

import com.example.gym.model.GymPriceInfo;
import com.example.gym.model.IpLiquidity;
import com.example.gym.repository.IpLiquidityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ipLiquidity")
@RequiredArgsConstructor
public class IpLiquidityController {
    private final IpLiquidityRepository ipLiquidityRepository;

    @GetMapping()
    public ResponseEntity<?> getAllIpLiquidity() {
        return ResponseEntity.status(HttpStatus.OK).body(ipLiquidityRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getIpLiquidityById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(ipLiquidityRepository.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteIpLiquidityById(@PathVariable Long id) {
        ipLiquidityRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping()
    public ResponseEntity<?> updateIpLiquidity(@RequestBody IpLiquidity ipLiquidity) {
        return ResponseEntity.status(HttpStatus.OK).body(ipLiquidityRepository.save(ipLiquidity));
    }

    @PostMapping()
    public ResponseEntity<?> insertIpLiquidity(@RequestBody IpLiquidity ipLiquidity) {
        return ResponseEntity.status(HttpStatus.OK).body(ipLiquidityRepository.save(ipLiquidity));
    }
}
