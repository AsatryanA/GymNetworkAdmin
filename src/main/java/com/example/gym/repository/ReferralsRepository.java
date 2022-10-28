package com.example.gym.repository;

import com.example.gym.model.Referral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReferralsRepository extends JpaRepository<Referral,Long> {
}
