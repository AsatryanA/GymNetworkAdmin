package com.example.gym.repository;

import com.example.gym.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface WalletsRepository extends JpaRepository<Wallet, Long> {
    Wallet findByAddress(String address);

    Wallet findByVerifiedCode(String verificationCode);

    boolean existsByAddress(String address);

    @Query(value = "WITH RECURSIVE wallet_tree AS (" +
            "(SELECT 1 AS depth, * FROM wallets  WHERE addre = ?1 ) " +
            "UNION ALL SELECT depth + 1, w. * FROM wallets  AS w " +
            "JOIN wallet_tree ON (w.referral_id  = wallet_tree .id))" +
            "SELECT * FROM wallet_tree", nativeQuery = true)
    List<Map<String,Object>> getPyramidById(Long id);


}
