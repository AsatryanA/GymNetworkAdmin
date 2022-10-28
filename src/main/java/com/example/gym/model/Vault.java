package com.example.gym.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "vaults")
public class Vault {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String slug;
    private String coin;
}
