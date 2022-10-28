package com.example.gym.repository;

import com.example.gym.model.Reward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RewardsRepository extends JpaRepository<Reward,Long> {
}
