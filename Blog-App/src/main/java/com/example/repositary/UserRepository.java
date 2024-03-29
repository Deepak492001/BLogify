package com.example.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    // Update method to use 'userId' instead of 'id'
    public User findByUserId(int userId);
    public boolean existsByEmail(String email);
    
    public User findByEmail(String email);
}
