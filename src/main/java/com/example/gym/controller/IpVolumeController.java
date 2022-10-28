package com.example.gym.controller;

import com.example.gym.model.IpLiquidity;
import com.example.gym.model.IpVolume;
import com.example.gym.repository.IpVolumeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ipVolume")
@RequiredArgsConstructor
public class IpVolumeController {
    private final IpVolumeRepository ipVolumeRepository;

    @GetMapping()
    public ResponseEntity<?> getAllIpVolume() {
        return ResponseEntity.status(HttpStatus.OK).body(ipVolumeRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getIpVolumeById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(ipVolumeRepository.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteIpVolumeById(@PathVariable Long id) {
        ipVolumeRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping()
    public ResponseEntity<?> updateIpVolume(@RequestBody IpVolume ipVolume) {
        return ResponseEntity.status(HttpStatus.OK).body(ipVolumeRepository.save(ipVolume));
    }

    @PostMapping()
    public ResponseEntity<?> insertIpVolume(@RequestBody IpVolume ipVolume) {
        return ResponseEntity.status(HttpStatus.OK).body(ipVolumeRepository.save(ipVolume));
    }
}
