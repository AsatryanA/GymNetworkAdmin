package com.example.gym.controller;


import com.example.gym.dto.*;
import com.example.gym.jwt.JwtUtils;
import com.example.gym.model.User;
import com.example.gym.model.Wallet;
import com.example.gym.repository.UserRepository;
import com.example.gym.repository.WalletsRepository;
import com.example.gym.service.WalletsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final WalletsRepository walletsRepository;
    private final WalletsService walletsService;


    @PostMapping("/initWallet")
    public ResponseEntity<?> register(@RequestBody InitWallet initWallet) {
        if (walletsRepository.existsByAddress(initWallet.getAddress())) {
            return ResponseEntity.status(HttpStatus.OK).body(new MessageDto("Already Exists"));
        }
        Wallet register = walletsService.register(initWallet);
        return ResponseEntity.status(HttpStatus.OK).body(new MessageDto(register.getVerifiedCode()));
    }

    @GetMapping("/get-verification-code")
    public ResponseEntity<?> getVerificationCode(@RequestParam String address) {
        Wallet byAddress = walletsRepository.findByAddress(address);
        if (byAddress == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MessageDto("Address Doesn't Exist!"));
        } else if (byAddress.getVerifiedCode().equals("0")) {
            return ResponseEntity.status(HttpStatus.OK).body(new MessageDto("Address is already verified"));
        }
        return ResponseEntity.status(HttpStatus.OK).body(new MessageDto(byAddress.getVerifiedCode()));
    }


    @GetMapping("/get-wallet")
    public ResponseEntity<?> getWallet(@RequestParam String address) {
        Wallet byAddress = walletsRepository.findByAddress(address);
        if (byAddress == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MessageDto("Address Doesn't Exist!"));
        }
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseWalletDto(byAddress.isVerified(), byAddress.isWithdrawals(), byAddress.getVerificationDate()));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto) {


        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword());
        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        User user = (User) authentication.getPrincipal();
        return ResponseEntity.ok(new UserDto(user.getUsername(), jwt));
    }


    @PostMapping("/register")
    public User register(@RequestBody User user) {
        User user1 = new User();
        user1.setName(user.getName());
        user1.setUsername(user.getUsername());
        user1.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user1);
    }
}


