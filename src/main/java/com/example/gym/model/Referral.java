package com.example.gym.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "referrals")
public class Referral {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long walletId;
    private Long referralId;
    private Integer rank;
}
