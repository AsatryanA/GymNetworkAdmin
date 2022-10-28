package com.example.gym.repository;
import com.example.gym.model.LiquidityMining;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LiquidityMiningRepository extends JpaRepository<LiquidityMining,Long> {
}
