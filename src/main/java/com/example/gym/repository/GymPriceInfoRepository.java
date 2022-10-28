package com.example.gym.repository;

import com.example.gym.model.Balance;
import com.example.gym.model.GymPriceInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GymPriceInfoRepository extends JpaRepository<GymPriceInfo,Long> {
}
