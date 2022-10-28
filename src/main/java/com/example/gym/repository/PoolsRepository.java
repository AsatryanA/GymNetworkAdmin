package com.example.gym.repository;

import com.example.gym.model.Pool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PoolsRepository extends JpaRepository<Pool,Long> {
}
