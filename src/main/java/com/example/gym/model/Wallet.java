package com.example.gym.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "wallets")
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    private String referralAddress;
    private Long referralId;
    private boolean isVerified;
    private boolean withdrawals;
    private String verifiedCode;
    private Date verificationDate;
    private String tgUsername;

}
