package com.example.gym.controller;

import com.example.gym.model.Vault;
import com.example.gym.repository.VaultsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vaults")
@RequiredArgsConstructor
public class VaultsController {
    private final VaultsRepository vaultsRepository;

    @GetMapping()
    public ResponseEntity<?> getAllVaults() {
        return ResponseEntity.status(HttpStatus.OK).body(vaultsRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getVaultsById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(vaultsRepository.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteVaultsById(@PathVariable Long id) {
        vaultsRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping()
    public ResponseEntity<?> updateVaults(@RequestBody Vault vault) {
        return ResponseEntity.status(HttpStatus.OK).body(vaultsRepository.save(vault));
    }

    @PostMapping()
    public ResponseEntity<?> insertVaults(@RequestBody Vault vault) {
        return ResponseEntity.status(HttpStatus.OK).body(vaultsRepository.save(vault));
    }
}
