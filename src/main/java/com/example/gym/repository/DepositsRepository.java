package com.example.gym.repository;

import com.example.gym.model.Deposit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepositsRepository extends JpaRepository<Deposit,Long> {
}
