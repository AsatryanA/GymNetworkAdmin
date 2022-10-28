package com.example.gym.repository;

import com.example.gym.model.Vault;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaultsRepository extends JpaRepository<Vault,Long> {
}
