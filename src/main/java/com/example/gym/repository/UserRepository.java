package com.example.gym.repository;

import com.example.gym.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer>  {
    User findUserByUsername(String username);
}
