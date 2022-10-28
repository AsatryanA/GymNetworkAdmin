package com.example.gym.dto;

import lombok.Data;

@Data
public class InitWallet {
    private String address;
    private String referralAddress;
    private Long referralId;
}
