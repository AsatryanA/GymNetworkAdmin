package com.example.gym.repository;

import com.example.gym.model.Balance;
import com.example.gym.model.IpLiquidity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IpLiquidityRepository extends JpaRepository<IpLiquidity,Long> {
}
