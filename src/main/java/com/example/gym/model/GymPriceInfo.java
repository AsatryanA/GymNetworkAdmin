package com.example.gym.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "gym_price_info")
public class GymPriceInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY
    )
    private Long id;
    private Date date;
    private double high;
    private double low;
}
