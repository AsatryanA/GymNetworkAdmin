package com.example.gym.repository;

import com.example.gym.model.Withdrawal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WithdrawalsRepository extends JpaRepository<Withdrawal, Long> {
}
