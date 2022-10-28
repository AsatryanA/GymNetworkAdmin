package com.example.gym.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "deposits")
public class Deposit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long walletId;
    private String type;
    private String coin;
    private double amount;
    private double APY;
}

