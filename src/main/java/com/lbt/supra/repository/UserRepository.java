package com.lbt.supra.repository;

import com.lbt.supra.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
    boolean existsByUsername(String username);
    Optional<UserEntity> findByUsername(String username);
}