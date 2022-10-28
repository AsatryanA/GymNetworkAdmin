package com.example.gym.controller;

import com.example.gym.model.GymPriceInfo;
import com.example.gym.repository.GymPriceInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gymPriceInfo")
@RequiredArgsConstructor
public class GymPriceInfoController {
    private final GymPriceInfoRepository gymPriceInfoRepository;

    @GetMapping()
    public ResponseEntity<?> getAllGymPriceInfo() {
        return ResponseEntity.status(HttpStatus.OK).body(gymPriceInfoRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getGymPriceInfoById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(gymPriceInfoRepository.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteGymPriceInfoById(@PathVariable Long id) {
        gymPriceInfoRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping()
    public ResponseEntity<?> updateGymPriceInfo(@RequestBody GymPriceInfo gymPriceInfo) {
        return ResponseEntity.status(HttpStatus.OK).body(gymPriceInfoRepository.save(gymPriceInfo));
    }

    @PostMapping()
    public ResponseEntity<?> insertGymPriceInfo(@RequestBody GymPriceInfo gymPriceInfo) {
        return ResponseEntity.status(HttpStatus.OK).body(gymPriceInfoRepository.save(gymPriceInfo));
    }
}
