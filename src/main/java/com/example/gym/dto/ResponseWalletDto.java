package com.example.gym.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ResponseWalletDto {
    private boolean isVerified;
    private boolean withdrawals;
    private Date verificationDate;
}
